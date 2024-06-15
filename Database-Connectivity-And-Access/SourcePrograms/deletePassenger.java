   public int deletePassenger(int passengerID) {
      
      int result = 0;
      try {
         sql = "DELETE FROM passenger WHERE passengerID=?";
      
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setInt(1, passengerID);
         
         result = ps.executeUpdate();
         return (result);
      
      } // end of try block
      catch (SQLException se) {
         return -1;
      }// end of catch block    
   }// end of deletePassenger