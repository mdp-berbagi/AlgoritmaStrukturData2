class Simpul{
   int data;
   Simpul kiri, kanan;
   
   Simpul (int data) {
      this.data = data;
   }
}

class BST{
   public Simpul akar;
   
   public void insert(int input) {
      Simpul temp = new Simpul(input);
      Simpul parent = null;
      Simpul penunjuk = null;
      
      // jika BST ini berakar ?
      if(this.akar == null) {
         
         // Bila tidak, akar dari BST ini adalah inputannya
         // Biasanya hanya untuk inputan pertama
         this.akar = temp;
      }else{
         // bila berakar, maka step ini di lakukan

         penunjuk = akar;
         parent = null;
         
         // perulangan selama penunjuk memiliki isi
         while(penunjuk != null){
            
            //penunjuk di cata parent 
            parent = penunjuk;
            
            // input lebih kecil atau lebih besar?
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

public class Traversal {
   public static void main(String[] args) {
      BST pohon = new BST();
      
      pohon.insert(12);
      pohon.insert(9);
      pohon.insert(10);
   }
}
