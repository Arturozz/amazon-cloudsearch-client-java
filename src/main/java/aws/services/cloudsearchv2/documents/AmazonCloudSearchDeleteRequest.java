package aws.services.cloudsearchv2.documents;

/**
 * This is class is used make a delete request for a document.
 * 
 * @author Tahseen Ur Rehman Fida
 * @email tahseen.ur.rehman@gmail.com
 */
public class AmazonCloudSearchDeleteRequest {
	private String id;
	private long version = 1;

	@SuppressWarnings("unused")
	private AmazonCloudSearchDeleteRequest() {
	}

	public AmazonCloudSearchDeleteRequest(Builder builder) {
		id = builder.id;
		version = builder.version;
	}

	public String getId() {
		return id;
	}

	public long getVersion() {
		return version;
	}

	public static class Builder {
		private String id;
		private long version = 1;

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

		public AmazonCloudSearchDeleteRequest build() {
			if (id == null || id.isEmpty()) {
				throw new IllegalArgumentException("id not be null or empty");
			}
			return new AmazonCloudSearchDeleteRequest(this);
		}
	}
}
