package aws.services.cloudsearchv2.documents;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This is class is used to request add or update of a document.
 * 
 * @author Tahseen Ur Rehman Fida
 * @email tahseen.ur.rehman@gmail.com
 */
public class AmazonCloudSearchAddRequest {
	private String id;
	private long version;
	private String lang;
	private Map<String, Object> fields = new LinkedHashMap<String, Object>();

	@SuppressWarnings("unused")
	private AmazonCloudSearchAddRequest() {
	}

	public AmazonCloudSearchAddRequest(Builder builder) {
		id = builder.id;
		version = builder.version;
		lang = builder.lang;
		fields = builder.fields;
	}

	public String getId() {
		return id;
	}

	public long getVersion() {
		return version;
	}

	public String getLang() {
		return lang;
	}

	public Map<String, Object> getFields() {
		return fields;
	}

	public static class Builder {
		private String id;
		private long version = 1;
		private String lang = "en";
		private Map<String, Object> fields = new LinkedHashMap<String, Object>();

		/**
		 * A unique ID for the document (docid). A document ID can contain the
		 * following characters: a-z (lower-case letters), 0-9, and _
		 * (underscore). Document IDs cannot begin with an underscore.
		 */
		public Builder withId(String id) {
			this.id = id;
			return this;
		}

		/**
		 * A document version number for the add or delete operation. The
		 * version is used to guarantee that older updates aren't accidentally
		 * applied, and to provide control over the ordering of concurrent
		 * updates to the service. The document service guarantees that the
		 * update with the highest version will be applied and remain there
		 * until an add or delete operation with a higher version number and the
		 * same document ID is received. If you submit multiple add or delete
		 * operations with the same version number, which one takes precedence
		 * is undefined. You must increase the version number every time you
		 * submit a new add or delete operation for a document.
		 */
		public Builder withVersion(long version) {
			this.version = version;
			return this;
		}

		/**
		 * The document language as a two-letter language code, such as en for
		 * English.
		 */
		public Builder withLang(String lang) {
			this.lang = lang;
			return this;
		}

		/**
		 * A name-value pair for each document field
		 */
		public Builder addField(String fieldName, String value) {
			this.fields.put(fieldName, value);
			return this;
		}

		/**
		 * A name-value pair for each document field
		 */
		public Builder addField(String fieldName, Integer value) {
			this.fields.put(fieldName, value);
			return this;
		}

		/**
		 * A name-value pair for each document field
		 */
		public Builder addField(String fieldName, Long value) {
			this.fields.put(fieldName, value);
			return this;
		}

		/**
		 * A name-value pair for each document field
		 */
		public Builder addField(String fieldName, List<String> values) {
			this.fields.put(fieldName, values);
			return this;
		}

		public AmazonCloudSearchAddRequest build() {
			if (id == null || id.isEmpty()) {
				throw new IllegalArgumentException("id not be null or empty");
			}
			if (fields.isEmpty()) {
				throw new IllegalArgumentException("fields must not be empty");
			}
			return new AmazonCloudSearchAddRequest(this);
		}
	}
}
