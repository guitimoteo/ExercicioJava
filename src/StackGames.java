import java.util.Stack;


public class StackGames {
Stack<Integer> S;
int[] A;

public StackGames(){
	this.S = new Stack<Integer>();// pode ser S=new Stack<Integer>>();
}


void m1(int[] b) {
	this.A = b; // Passando o parametro para o atributo do objeto. 
	if(A.length == 0) //Se o tamanho do vetor for igual a 0, significa que está vazio
	return;
	else if(this.S.empty())
		S.push(Integer.valueOf(A[0]));// Coloca o elemento no topo
	else if(A.length==S.firstElement())
		S.pop();
	
}	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackGames stackGames = new StackGames();
		int[] B = {0,1,2,3,4};
		stackGames.m1(B);
		
		for (int i = 0; i < stackGames.S.size(); i++) {
			System.out.println(stackGames.S.get(i));
		}
		
	}





}
