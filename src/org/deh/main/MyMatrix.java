package org.deh.main;



public class MyMatrix {

	// Aufgabe 2a)
	// int-Attribute m(Anzahl der Zeilen), n(Anzahl der Spalten) und M(Matrix
	// selbst)
	int m;
	int n;
	int[][] M;

	// Konstruktors fuer nxn und mxn Matrix

	public MyMatrix(int k) {
		m = k;
		n = k;
		M = new int[m][n];
	}

	public MyMatrix(int k, int j) {
		m = k;
		n = j;
		M = new int[m][n];
	}

	// Methode transpose

	public MyMatrix transpose() {
		MyMatrix T = new MyMatrix(n, m);
		for (int x = 0; x < m; x++)
			for (int i = 0; i < n; i++) {
				T.M[i][x] = M[x][i];
			}
		return T;
	}

	// Ausgabefunktion matrixOut

	public void MatrixOut() {
		for (int x = 0; x < m; x++) {
			for (int i = 0; i < n; i++) {
				System.out.print(M[x][i] + " ");
			}
			System.out.println();
		}
	}

	// Aufgabe 2 b)
	// fill1: fuellt die Matrix mit k; k*k; (k+1)*(k+1)...usw
	public void fill1(int k) {
		int c = k - 1;
		for (int x = 0; x < m; x++) {
			for (int i = 0; i < n; i++) {
				M[x][i] = k;
				if (c > 0) {
					c--;
				} else {
					c = k++;
				}
			}
		}
	}

	// fill2: fuellt die Matrix mit k und l, sodass k;k+1;k+2;..;k+l;k;k+1...
	public void fill2(int k, int l) {
		int fillVal = k;
		int c = 0;
		for (int x = 0; x < m; x++)
			for (int i = 0; i < n; i++) {
				M[x][i] = fillVal;
				c++;
				if (c <= l)
					fillVal++; // Fuellwert erhoehen
				else {
					fillVal = k; // wieder von vorn
					c = 0;
				}
			}
	}

	// Aufgabe 2c)
	// countSymm: Anzahl der symmetrischen Eintraege
	public int countSymm() {
		int c = 0;
		for (int x = 0; x < m; x++)
			for (int i = 0; i < n; i++) {
				if (M[x][i] == M[i][x])
					c++; // c erhoehen, wenn die Eintraege gleich sind
			}
		return c;
	}

	// checkSym: ob alle Eintraege symmetrisch sind

	public boolean checkSymm() {
		boolean bool = true;
		// wenn die Anzahl von Zeilen und Spalten unterschiedlich sind, ist
		// nicht symmetrisch
		if (m != n) {
			bool = false;
		} else {
			for (int x = 0; x < m; x++)
				for (int i = 0; i < n; i++) {
					if (M[x][i] != M[i][x]) {// wenn Zeilen und Spalten
												// unterschiedlich sind, ist
												// nicht symm.
						bool = false;
						break;
					}
				}
		}
		return bool;
	}
	
	//Aufgabe 2d)
	
    public int countDiffCols() {                            
        int k =0;
        MyMatrix temp = this.transpose();
        for(int x=0;x<temp.m;x++){
                for(int y=x+1;y<temp.m;y++){
                        if(this.isEqual(temp.M[x], temp.M[y])==true)
                                k++;
                }
        }
        return k;
}
public int maxNumberEqualCols() {
        int k =0;
        MyMatrix temp = this.transpose();
        for(int x=0;x<temp.m;x++){
                for(int y=x+1;y<temp.m;y++){
                        if(this.isEqual(temp.M[x], temp.M[y])==false)
                                k++;
                }
        }
        return k;
}
//Hilfsfunktion
public boolean isEqual(int[] a, int[] b){ 
        for(int i=0; i<a.length;i++){
                if(a[i]!=b[i])
                        return false;
        }
        return true;
}

public boolean isLetter(char c){
	String letter ="abcdefghijklmnopqrstuvxwyz?.-ABCDEFGHIJKLMNOPQRSTUVXWYZ";
	Character character =Character.valueOf(c);
	character.isDigit(c);
	if(letter.contains(String.valueOf(c)))
		return true;
	else
		return false;
	
}

public boolean isDigit(char c){
	String letter ="1234567890";
	
	if(letter.contains(String.valueOf(c)))
		return true;
	else
		return false;
}

public static void stringTest(){
	String string = "Was345kommt-raus?";
	char[] vetorString = string.toCharArray();// transformando String em char
	int digito = 0, letra  = 0;
	
	for (int i = 0; i < vetorString.length; i++) {
		char vetorChar = vetorString[i];
		if(Character.isDigit(vetorChar))
			digito++;
		if(Character.isLetter(vetorChar))
			letra++;
	}
	
	System.out.println("Der String "+string+" enthaelt "+ letra +" Buchstaben und "+ digito +" Ziffern.");	
}


	public static void main(String[] args) {
stringTest();
//testa1();

	}

	public static void test() {
		MyMatrix M = new MyMatrix(5);
		System.out.println("Matrixout(5); M.countDiffCols; maxNumberEqualCols /Bsp.1");
		M.MatrixOut();
		M.countDiffCols();
		System.out.println(M.countDiffCols());
		M.maxNumberEqualCols();
		System.out.println(M.maxNumberEqualCols());
		System.out.println();

		MyMatrix W = new MyMatrix(5, 2);
		System.out.println("Matrixout(5, 2);");
		W.MatrixOut();
		System.out.println();

		M.fill1(1);
		System.out.println("M.fill1(1); M.countDiffCols; M.maxNumberEqualCols /Bsp.2");
		M.MatrixOut();
		M.countDiffCols();
		System.out.println(M.countDiffCols());
		M.maxNumberEqualCols();
		System.out.println(M.maxNumberEqualCols());
		System.out.println();

		M.fill2(2, 7);
		System.out.println("M.fill2(2, 7);");
		M.MatrixOut();
		System.out.println();

		MyMatrix D = new MyMatrix(5);
		D = M.transpose();
		System.out.println("M.fill2(2, 7) transpose");
		D.MatrixOut();
		System.out.println();

		W.fill1(1);
		System.out.println("W.fill1(1);");
		W.MatrixOut();
		System.out.println();

		MyMatrix Y = new MyMatrix(2, 5);
		Y = W.transpose();
		System.out.println("W.fill1(1) transpose; Y.countDiffCols; Y.maxNumberEqualCols /Bsp.3");
		Y.MatrixOut();
		Y.countDiffCols();
		System.out.println(Y.countDiffCols());
		Y.maxNumberEqualCols();
		System.out.println(Y.maxNumberEqualCols());
		System.out.println();

		W.fill2(2, 5);
		System.out.println("W.fill2(2, 5);");
		W.MatrixOut();
		System.out.println();
		
		MyMatrix Z = new MyMatrix(2, 5);
		Z = W.transpose();
		System.out.println("W.fill2(2, 5) transpose");
		Z.MatrixOut();
		System.out.println();

		MyMatrix Q = new MyMatrix(4);
		Q.fill1(0);
		Q.checkSymm();
		Q.countSymm();
		System.out.println("M.fill1(0); checkSymm; countSymm");
		Q.MatrixOut();
		System.out.println(Q.checkSymm());
		System.out.println(Q.countSymm());
		System.out.println();

		MyMatrix R = new MyMatrix(4);
		R.fill2(1, 2);
		R.checkSymm();
		R.countSymm();
		System.out.println("fill2(1, 2); checkSymm; countSymm");
		R.MatrixOut();
		System.out.println(R.checkSymm());
		System.out.println(R.countSymm());
		System.out.println();

	}
}
