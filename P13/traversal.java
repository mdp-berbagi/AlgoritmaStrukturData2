import java.util.*;

class Simpul {
   int data;
   Simpul kiri, kanan;
   Simpul() {
      
   }
   
   Simpul(int data) {
      this.data = data;
   }
   
   public void setData(int value) {
      this.data = value;
   }
   
   public int getData() {
      return this.data;
   }
}

class BST {
   public Simpul akar;
   public void insert(int input) {
      Simpul temp = new Simpul(input);
      Simpul parent = null;
      Simpul penunjuk = null;
      
      if(this.akar == null) {
         akar = temp;
      }else{
         penunjuk = akar;
         parent = null;
         
         while(penunjuk != null) {
            parent = penunjuk;
            if(input < penunjuk.data) {
               penunjuk = penunjuk.kiri;
            }else{
               penunjuk = penunjuk.kanan;
            }
         }
         
         if(input < parent.data) {
            parent.kiri = temp;
         }else{
            parent.kanan = temp;
         }
      }
   }
}

public class traversal {
   public static void preOrder(Simpul root) 
   {
      if(root == null) return;
      System.out.print(root.getData() + " ");
      preOrder(root.kiri);
      preOrder(root.kanan);
   }
   
   public static void inOrder(Simpul root) {
      if(root == null) return;
      
      inOrder(root.kiri);
      System.out.print(root.getData() + " ");
      inOrder(root.kanan);
   }
   
   public static void postOrder(Simpul root) {
      if(root == null) return;
      postOrder(root.kiri);
      postOrder(root.kanan);
      System.out.print(root.getData() + " ");
   }
   
   public static void main(String[] args) {
      BST pohon = new BST();
      pohon.insert(7);   
      pohon.insert(1);
      pohon.insert(9);
      pohon.insert(0);
      pohon.insert(3);
      pohon.insert(8);
      pohon.insert(10);
      pohon.insert(2);
      pohon.insert(5);
      pohon.insert(4);
      pohon.insert(6);

      
      Simpul tmp = pohon.akar;
      
      System.out.println("PreOrder : ");
      preOrder(tmp);
      
      System.out.println("");
      
      System.out.println("InOrder : ");
      inOrder(tmp);
      
      System.out.println("");
      
      System.out.println("postOrder : ");
      postOrder(tmp);
   }
}
