package micronaut.upload;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.multipart.PartData;
import io.micronaut.http.multipart.StreamingFileUpload;
import io.reactivex.Single;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicLong;

@Controller("/upload")
public class UploadController implements IReporter {

	public static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	@Inject protected ReportService reportService;

	@Post(consumes = MediaType.MULTIPART_FORM_DATA, produces = MediaType.TEXT_PLAIN)
	public Single<String> uploadPublic(StreamingFileUpload file) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		AtomicLong total = new AtomicLong(0);

		return Single.create(emitter -> {

			file.subscribe(new Subscriber<PartData>() {

				protected Subscription s;

				@Override
				public void onSubscribe(Subscription s) {
					this.s = s;
					s.request(1);
				}

				@Override
				public void onNext(PartData it) {
					try {
						byte[] bytes = it.getBytes();
						out.write(bytes);
						reportService.report(UploadController.this, total.addAndGet(bytes.length));
						Thread.sleep(100);
						s.request(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				@Override
				public void onError(Throwable t) {
					emitter.onError(t);
				}

				@Override
				public void onComplete() {
					try {
						out.close();
						report(total.get());
						emitter.onSuccess("OK");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

		});
	}

	@Override
	public void report(long bytes) {
		logger.info(IReporter.readableFileSize(bytes));
	}

}
