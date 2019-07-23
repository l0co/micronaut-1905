package micronaut.upload;

import io.micronaut.test.annotation.MicronautTest;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * See https://stackoverflow.com/questions/7057342/how-to-get-a-progress-bar-for-a-file-upload-with-apache-httpclient-4
 */
@MicronautTest
public class UploadTest {

	@Test
	public void testWithApacheHttpClient() throws Exception {
		post("http://localhost:8080/upload", new File("/media/data/tmp/micronaut-tests/micronaut-1905/test/file.txt")); // TODOLF replace path
	}

	public void post(String url, File sendFile) throws IOException {
		HttpParams params = new BasicHttpParams();
		params.setParameter(HttpProtocolParams.USE_EXPECT_CONTINUE, true);
		HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpClient client = new DefaultHttpClient(params);
		HttpPost post = new HttpPost(url);
		MultipartEntity multiEntity = new MultipartEntity();
		MyFileBody fileBody = new MyFileBody(sendFile);

		fileBody.setListener(new IStreamListener(){

			@Override
			public void counterChanged(int delta) {
				// do something
				System.out.println("********************************************* " + delta);
			}});

		multiEntity.addPart("file", fileBody);
		StringBody stringBody = new StringBody(sendFile.getName());
		multiEntity.addPart("fileName", stringBody);
		post.setEntity(multiEntity);
		HttpResponse response = client.execute(post);
	}

	public static class MyFileBody extends FileBody {

		private IStreamListener listener;

		public MyFileBody(File file) {
			super(file);
		}

		@Override
		public void writeTo(OutputStream out) throws IOException {
			CountingOutputStream output = new CountingOutputStream(out) {
				@Override
				protected void beforeWrite(int n) {
					if (listener != null && n != 0)
						listener.counterChanged(n);
					super.beforeWrite(n);
				}
			};
			super.writeTo(output);

		}

		public void setListener(IStreamListener listener) {
			this.listener = listener;
		}

		public IStreamListener getListener() {
			return listener;
		}

	}

	public interface IStreamListener {

		void counterChanged(int delta);

	}


}
