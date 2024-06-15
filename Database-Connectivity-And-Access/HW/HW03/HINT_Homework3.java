public void getResultSet(int candidateID) {
    try {

        String query = "{CALL get_candidate_skill(?)}";
        CallableStatement stmt = conn.prepareCall(query);
        stmt.setInt(1, candidateID);

        rs = stmt.executeQuery();

        String output = new String();
        String heading = new String();
        heading  = "\nDatabase candidateSkills\n";
        heading +=  "ID \tCandidate Name \t       Skills";
        System.out.println(heading);
        // Test (condition of while loop) if there are query results
        while (rs.next()) {
            // Retrieve resultset data to print on the screen

            int    id    = rs.getInt(1);
            String name  = rs.getString(2);
            String skill = rs.getString(3);
            System.out.printf("%3d     %-22s %-60s",id, name, skill);
        }// end of while loop, end of processing the result set

    }//end of try
    catch (SQLException sqle) {
        System.out.println("\nERROR CAN NOT getResultSet()");
        System.out.println("ERROR MESSAGE-> " + sqle + "\n");
        sqle.printStackTrace();
    }// end of catch
}// end of method getResultSet()