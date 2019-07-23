package micronaut.upload;

import javax.inject.Singleton;
import java.util.Objects;

@Singleton
public class ReportService {

	protected IReporter reporter = null;

	public void reset() {
		this.reporter = null;
	}

	public synchronized void report(IReporter reporter, long bytes) {
		if (!Objects.equals(this.reporter, reporter)) {
			this.reporter = reporter;
			reporter.report(bytes);
		}
	}

}
