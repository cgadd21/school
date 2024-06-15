class StringInfo{
   public static void main(String[] args){
      String quote = new String("There is snow outside today.");
      int length = quote.length();
      int index = quote.indexOf(" ");
      String firstFive = quote.substring(0,5);
      String lastFive = quote.substring(quote.length() - 5);
      System.out.println("The quote: " + quote);
      System.out.println("The lengh of this quote is " + length + " characters.");
      System.out.println("The first space is at index " + index + ".");
      System.out.println("The first 5 characters are: " + firstFive);
      System.out.println("The last 5 characters are: " + lastFive);
   }
}