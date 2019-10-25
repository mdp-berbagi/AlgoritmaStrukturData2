package traversal;

class Simpul {
    int data;
    Simpul kiri;
    Simpul kanan;

    Simpul() {

    }

    Simpul(int data) {
        this.data = data;
    }

    public void setData(int value) {
        this.data = value;
    }

    public int getData() {
        return data;
    }
}

class BST {
    public Simpul akar;

    public void insert(int input) {
        Simpul temp = new Simpul(input);
        Simpul parent = null;
        Simpul penunjuk = null;

        if (akar == null) {
            akar = temp;
        } else {
            penunjuk = akar;
            parent = null;

            while (penunjuk != null) {
                parent = penunjuk;

                if (input < penunjuk.data) {
                    penunjuk = penunjuk.kiri;
                } else {
                    penunjuk = penunjuk.kanan;
                }
            }
            if (input < parent.data) {
                parent.kiri = temp;
            } else {
                parent.kanan = temp;
            }
        }
    }
    
    public void hapusSimpulDaun(int i) {
        Simpul y = null;
        Simpul x = akar;

        while ((x != null) && (x.data != i)) {
            y = x;

            if (i < x.data) {
                x = x.kiri;
            } else {
                x = x.kanan;
            }
        }

        if (x == null) {
            System.out.println("tidak ditemukan");
        } else {
            if (i < y.data) {
                y.kiri = null;
            } else {
                y.kanan = null;
            }
        }
    }

    public void hapus2Anak(int i) {
        Simpul y = null;
        Simpul x = akar;
        
        while ((x != null) && (x.data != i)) {
            y = x;

            if (i < x.data) {
                x = x.kiri;
            } else {
                x = x.kanan;
            }
        }
        if (x == null) {
            System.out.println("tidak ditemukan");
        } else {

            Simpul p = x.kanan;
            Simpul r = x;
            if (p.kiri != null) {
                p = p.kiri;
            }
            while (p.kiri != null) {
                r = p;
                p = p.kiri;
            }
            x.data = p.data;
            if (p.kanan != null) {
                r.kanan = p.kanan;
            } else {
                r.kanan = null;
            }
        }
    }
}

public class Traversal {
    public static void inOrder(Simpul root) {
        if (root == null)
            return;
        inOrder(root.kiri);
        System.out.print(root.getData() + " ");
        inOrder(root.kanan);
    }

    public static void main(String[] args) {
        BST pohon = new BST();
        pohon.insert(12);
        pohon.insert(8);
        pohon.insert(10);
        pohon.insert(20);
        pohon.insert(15);
        pohon.insert(24);
        pohon.insert(17);
        pohon.insert(9);

        Simpul tmp = pohon.akar;
        System.out.println("InOrder :");
        inOrder(tmp);
        System.out.println("");
        pohon.hapusSimpulDaun(9);

        System.out.println("InOrder :");
        inOrder(tmp);
        System.out.println("");
        
        pohon.insert(11);
        System.out.println("InOrder :");
        inOrder(tmp);
        System.out.println("");
        pohon.hapus2Anak(20);
        System.out.println("InOrder :");
        inOrder(tmp);

    }

}
