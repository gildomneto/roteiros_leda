package problems;

/**
 *
 * Dado um array ordenado de elementos comparaveis e um outro elemento comparavel, 
 * implemente o metodo que conte as ocorrências do elemento no array. 
 *
 * Restricoes:
 * - a complexidade esperada é O (log.n). Soluções com tempo O(n) ou superiores serão desconsideradas.
 * - voce nao pode usar memoria extra
 * - voce nao pode usar metodos prontos da bilbioteca de arrays (exceto o metodo length)
 * - Dica: tente pensar numa forma eficiente (em log n) de descobrir a posicao de um 
 *   elemento no array e use essa ideia para contar as ocorrencias desse elemento no array
 *
 * @author campelo
 *
 * @param <T>
 */
public class OccurrencesCounterImpl<T extends Comparable<T>> {
   /*
    * Se elem está presente no array[], retorna a quantidade de ocorrências de elem.
    * Caso contrário, retorna 0.
    */
   public int count(T[] array, T elem) {
      return conta(array, elem, 0, array.length);
   }

   private int conta(T[] array, T elem, int leftIndex, int rightIndex) {

      int middle = (leftIndex + rightIndex) / 2;
      int ocorrencias = 0;

      if (leftIndex < rightIndex) {

         if (array[middle].compareTo(elem) == 0) {
            return 1 + conta(array, elem, leftIndex, middle) + conta(array, elem, middle +1 , rightIndex);
         } else if (array[middle].compareTo(elem) > 0){
            return conta(array, elem, leftIndex, middle);
         } else if (array[middle].compareTo(elem) < 0){
            return conta(array, elem, middle + 1 , rightIndex);
         } else {
            return 0;
         }
      }

      return ocorrencias;
   }

   //isso aqui é so o teste, qdo for enviar a prova tem q apagar
   public static void main(String[] args){
      OccurrencesCounterImpl teste = new OccurrencesCounterImpl();
      Integer array[] = {1,2,3,4,5,6,6,6,6,7,8,9};

      System.out.println(teste.count(array, 6));


   }
}