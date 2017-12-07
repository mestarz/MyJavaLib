/**
 * Class <em>SortAlgorithm</em> 有关排序算法的类
 * 
 * @author starysky
 */
public class SortAlgorithm{

  /**
   * <em>BubbleSort</em> 冒泡排序，int整型升序版
   * 将给定的int数组由小到大排序
   * 
   * @param 待排序的数组
   */
  public static void BubbleSort(int[] a){

    int i,j,temp;
    for(i = 0; i < a.length; i++){
      for(j = i + 1; j < a.length; j++){
        if(a[i] > a[j]){
          temp = a[i];
          a[i] = a[j];
          a[j] = temp;
        }
      }
    }
  }

  /**
   * <em>InsertSort</em> 插入排序，int整形升序
   * 将给定的int数组由小到大排序
   * 
   * @param 待排序的数组
   */
  public static void InsertSort(int[] a){
    int i,j,temp;
    for(i = 0; i < a.length; i++){
      temp = a[i];
      for(j = i - 1; j >= 0 && a[j] > temp; j--){
        a[j+1] = a[j];    //已经排序中的数据比当前数据大，将其后移;
      }
      a[j+1] = temp;
    }
  }

  /**
   * <em>MergeSort</em> 归并排序，int整形升序
   * 将给定的int数组由小到大排序
   * 
   * @param 待排序的数组
   */
  public static void MergeSort(int[] a){
    merge(a, 0, a.length - 1);
  }

  /**
   * <em>merge</em> 归并排序的递归调用函数
   * 将给定int数组的一部分由小到大排序
   * 
   * @param 待排序的数组
   * @param 起始位置
   * @param 终止位置
   */
  private static void merge(int[] a, int start, int end){

    if(end - start >= 1){
      int p = (start + end) / 2;
      merge(a, start, p);
      merge(a, p+1, end);

      //合并
      int[] b = new int[end - start + 1];
      int n = 0;      //记录b下标
      int i = start;  //记录左半部分下标
      int j = p + 1;  //记录右半部分下标
      while(i <= p || j <= end){
        if(i > p){
          b[n] = a[j];
          j++;
        }
        else if(j > end){
          b[n] = a[i];
          i++;
        }
        else{
          if(a[i] < a[j]){
            b[n] = a[i];
            i++;
          }
          else{
            b[n] = a[j];
            j++;
          }
        }
        n++;
      }

      //复制
      for(int k = start; k <= end; k++){
        a[k] = b[k-start];
      }
    }
  }

  /**
   * <em>QuickSort</em> 快速排序，int整形升序
   * 将给定int数组的一部分由小到大排序
   * 
   * @param 待排序的数组
   */
  public static void QuickSort(int[] a){
    quick(a, 0, a.length - 1);
  }

  /**
   * <em>quick</em> 快速排序的递归调用函数
   * 将给定int数组的一部分快速排序
   * 
   * @param 待排序的数组
   * @param 起始位置
   * @param 终止位置
   */
  private static void quick(int[] a, int start, int end){
    if(end - start >= 1){
      int flag = a[start];
      int[] left = new int[end - start];
      int[] right = new int[end - start];
      int l = 0; //左半下标
      int r = 0; //右半下标
      
      for(int i = start + 1; i <= end; i++){
        if(a[i] > flag){
          right[r] = a[i];
          r++;
        }
        else{
          left[l] = a[i];
          l++;
        }
      }
      
      //合并
      for(int i = 0; i < l; i++){
        a[start + i] = left[i];
      }
      a[start + l] = flag; 
      for(int i = 0; i < r; i++){
        a[start + l + i + 1] = right[i];
      }

      //递归调用
      quick(a, start, start + l - 1);
      quick(a, start + l + 1, end);
    }
  }

  /**
   * 用于测试
   */
  public static void main(String[] args) {
    int[] a = {1, 2, 3,234,2123,123,123,21,3,46,342,1234, 4, 1, 4, 5, 1};
    SortAlgorithm.QuickSort(a);
    Test.say(a);
    SortAlgorithm.BubbleSort(a);
    Test.say(a);
    SortAlgorithm.InsertSort(a);
    Test.say(a);
    SortAlgorithm.MergeSort(a);
    Test.say(a);
  }
}
