	/**
	 * Starts a DB transaction
	 *
	 * @param conn, db connection
	 * @return if start executed
	 */
	public boolean startTransaction(Connection conn) {
		try {
			// Start transaction
			conn.setAutoCommit(false);
			return true;
		} catch (Exception e) {
			return false;
		} // end of catch
	} // end of method startTransaction

	/**
	 * Ends a transaction
	 *
	 * @param conn, db connection
	 * @return if end executed
	 */
	public boolean endTransaction(Connection conn) {
		try {
			// end transaction
			conn.setAutoCommit(true);
			return true;
		} catch (Exception e) {
			return false;
		} // end of catch
	} // end of method endTransaction

	/**
	 * Rollback the DB
	 *
	 * @param conn, db connection
	 * @return fi rollback executed
	 */
	public boolean rollbackTransaction(Connection conn) {
		try {
			// Rollback

			conn.rollback();
			System.out.println();
			System.out.println("Rolling back!  NO CHANGES  have been made");
			return true;
		} catch (Exception e) {

			return false;
		} // end of catch

	} // end of method Rollback

	/**
	 * commit the DB
	 *
	 * @param conn, db connection
	 */
	public boolean commitTransaction(Connection conn) {
		try {
			// commit

			conn.commit();
			System.out.println();
			System.out.println("Committing the Changes.");
			return true;
		} catch (Exception e) {

			return false;
		} // end of catch

	} // end of method commit