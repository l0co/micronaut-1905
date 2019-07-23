package micronaut.upload;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Singleton
public class ReportService {

	protected IReporter currentReporter = null;

	protected Map<IReporter, Long> currentValues = new HashMap<>();

	public void reset() {
		this.currentReporter = null;
		currentValues.clear();
	}

	public synchronized void report(IReporter reporter, long bytes) {
		currentValues.put(reporter, bytes);

		if (!Objects.equals(this.currentReporter, reporter)) {
			if (this.currentReporter!=null)
				this.currentReporter.report(currentValues.get(this.currentReporter));

			this.currentReporter = reporter;
			reporter.report(bytes);
		}
	}

}
