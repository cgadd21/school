//1
class Box{
   //2
   private double width;
   private double length;
   private double height;
   //3
   public Box(){
      width=1.0;
      length=1.0;
      height=1.0;
   }   
   public Box(double num1, double num2){
      width=num1;
      length=num2;
      height=1.0;
   }   
   public Box(double num1, double num2, double num3){
      width=num1;
      length=num2;
      height=num3;
   }
   //4
   public double getWidth(){
      return width;
   }
   public double getLength(){
      return length;
   }
   public double getHeight(){
      return height;
   }
   
   public void setWidth(double num1){
      width=num1;
   }
   public void setLength(double num2){
      length=num2;
   }
   public void setHeight(double num3){
      height=num3;
   }
   //5
   public String toString(){
      return width+"W x "+length+"L x "+height+"H.";
   }
   //6
   public Box add(Box box){
      double newWidth=this.getWidth() + box.getWidth();
      double newLength=this.getLength() + box.getLength();
      double newHeight=this.getHeight() + box.getHeight();
      Box newBox = new Box(newWidth, newLength, newHeight);
      return newBox;
   }
   //7
   public Box add(double num){
      double newWidth=this.getWidth() + num;
      double newLength=this.getLength() + num;
      double newHeight=this.getHeight() + num;
      Box newBox = new Box(newWidth, newLength, newHeight);
      return newBox;
   }
   //8
   public boolean equals(Box box){
      double width1=this.getWidth();
      double width2=box.getWidth();
      double length1=this.getLength();
      double length2=box.getLength();
      double height1=this.getHeight();
      double height2=box.getHeight();
      if(width1==width2 && length1==length2 && height1==height2){
         return true;
      }
      return false;
   }
   //9
   private static final double BIG=20.0;
   
   //10
   public boolean isBig(){
      double width=this.getWidth();
      double length=this.getLength();
      double height=this.getHeight();
      if(width+length+height>BIG){
         return true;
      }
      return false;
   }
}