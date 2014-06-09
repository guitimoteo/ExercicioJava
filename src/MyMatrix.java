public class MyMatrix{

	// Attribute:
	public int m,n, aux; // length of array
	public int M[][]; 

	
	// Konstruktor:
	public MyMatrix(int k){
		n = k;
		m = k;
		M = new int[m][n];
	}
	
	public MyMatrix(int k, int j){
		m = k;
		n = j;
		M = new int[m][n];
	}
	
	/**
	 * a)Implementieren Sie eine zeilenweise Ausgabefunktion matrixOut() (Typ void).
	 */
	public void matrixOut(){	
		for(int x = 0;x<M.length;x++){
			for (int i=0;i<M[x].length ;i++){
				System.out.print(M[x][i] + " ");
			}
			System.out.println();
		}
	}

	/*
	public int[][] transpose(){ 
		MyMatrix T = new MyMatrix (i, j); 
		for (int i=0;i<n; i++){
			T.M[i] = M[j]; 
			for (int j=0;j<n; j++)
			{ T.M[j] = M[i];
			}
		}
	}
	*/
	
	// Methoden:
	
	// Füllt das Array mit aufsteigenden Werten
	// beginnent bei k
	public void fill1(int k){
		for(int x = 0;  x<n;x++){
			for (int i=0;i<m;i++){
				M[x][i] = (k + i)*(k + i);
			}
		}
	}
	
/**
 * Exemplo para Deh.
 * O método é estático. Então vc só precisa executar dentro do main() desse jeito:
 * public static void main(String[] args){
 * testeFill3(3);
 * }
 * Depois me pergunta para a gente fazer o passo a passo no Debug do Eclipse
 * @param k
 */
	public static void testeFill1(int k){
		int n = 3;
		int m = 4;
		int[][] M;
		M = new int[n][m];// matriz M 2X3
		System.out.println("Criado a matriz M[3][4]");
		for(int x = 0;  x<n;x++){// primeiro laço para linha
		System.out.println("1ºlaço-for(int x = 0;  x<n;x++)		 x= " + x);
		System.out.println("Logo: for(int x = "+ x +"; "+x+"<"+n+";x++)	 	 x= " + x);
			for (int i=0;i<m;i++){// segundo laço para coluna
				//Repare que um laço está dentro do outro
				M[x][i] = (k + i)*(k + i);// O 'x' está sendo usado como coluna, e o 'i' como linha
				System.out.println("  2ºlaço-for(int i=0;"+i+"<"+m+";i++) 	i= "+i);
				System.out.println("	 M["+x+"]["+i+"] = ("+k+"+"+i+")*("+k+"+"+i+");		 X="+x+" I="+i+" K="+k);
				/**
				 * Como um "for" está dentro do outro, para o primeiro "for" dar uma passada
				 * o segundo "for" que está dentro dele, tem que terminar o laço inteiro, ou seja
				 * chegar à i= 3. Depois o primeiro for vai somar x+1 novamente e passar para o 
				 * segundo for, que vai começar com i= 0 tudo de novo.
				 */
			}
			System.out.println("------------------------------------------------------");
		}
	}
	
	
	// Füllt das Array mit aufsteigenden Werten
	// beginnent bei k 
	// sobalt Wert k+l erreicht wird wieder bei k begonnen
	public void fill2(int k, int l){
		int fillVal = k;
		int c = 0;
		for(int x = 0;x<n;x++)
		for (int i=0;i<m;i++){
			M[x][i] = fillVal;
			c++;
			if(c <= l) fillVal++;  // Fuellwert erhoehen
            else{  //
				fillVal=k; // wieder von vorn
                c=0;
			}
		}
	}
	
	// Schreibt den Inhalt des Arrays in die Kommandozeile
	public void ArrayOut(){
		for(int x = 0;x<n;x++){
		for (int i=0;i<m;i++){
			System.out.print(M[x][i] + " ");
		}
		System.out.println();
		}
	}
		
	// Anzahl der Vorkommnisse von k im Array
	public int countEqual(int k){
		int c = 0;
		for(int x = 0;x<n;x++)
		for (int i=0;i<m;i++){
			if (M[x][i]==k) c++;
		}
		return c;
	}
	
	public boolean elem(int k){
		boolean bool = false; 
		for(int x = 0;x<n;x++)
		for (int i=0;i<m;i++){
			if (M[x][i]==k){bool=true;break;}
		}
		return bool;
	}	
	
	// {1,2,3,4} -> {4,3,2,1} : Acredito que é a tranposição
	public MyMatrix reverse(){
		MyMatrix T = new MyMatrix(n,m);//O inverso da matriz M[m][n] é M[n][m] não?
		for(int x = 0;x<n;x++)
			for (int i=0; i<m; i++){
				T.M[x][i] = M[i][x];
			}
		return T;
	}
		
	public static void main(String[] args)
    {
		test();
		testeFill1(3);//Apague-me após testar
		
	}
	
	public static void test(){
		MyMatrix G = new MyMatrix(5);
		G.matrixOut();
		
		System.out.println("G.fill1(5)");
		
		G.fill1(5);
		G.matrixOut();
		
		System.out.println();
		
		System.out.println("MyMatrix(20)");
		MyMatrix Q = new MyMatrix(20);
		System.out.println("Q.fill2(5,3)");
		Q.fill2(5,3);
		Q.matrixOut();
		
		MyMatrix matrixTransp = Q.reverse();
		System.out.println("Q.reverse();");
		matrixTransp.matrixOut();
		
		System.out.println("\r\nQ.countEqual(6)");
		
		int numEqu = Q.countEqual(6);
		System.out.println(numEqu);
		
		System.out.println("Q.elem(7)");
		
		System.out.println(Q.elem(7));
		
		System.out.println("Q.elem(10)");
		
		System.out.println(Q.elem(10));
		
		System.out.println();
		System.out.println("MyMatrix(5)");
		MyMatrix R = new MyMatrix(5);
		R = G.reverse();
		System.out.println("R.matrixOut()");
		R.matrixOut();
		
    
	}	



}