package micronaut.upload;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.multipart.PartData;
import io.micronaut.http.multipart.StreamingFileUpload;
import io.reactivex.Single;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.ByteArrayOutputStream;

@Controller("/upload")
public class UploadController {

	@Post(consumes = MediaType.MULTIPART_FORM_DATA, produces = MediaType.TEXT_PLAIN)
	public Single<String> uploadPublic(StreamingFileUpload file) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

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
						System.out.println("SERVER PROGRESS: "+bytes.length);
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
						System.out.println("SERVER DONE");
						emitter.onSuccess("OK");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

		});
	}

}
