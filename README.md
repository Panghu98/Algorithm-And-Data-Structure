 # 算法
 ## 排序算法
 ### 各种排序算法的时间复杂度
 ![时间复杂度](https://github.com/Panghu98/algorithm-data-structure/blob/master/picture/时间复杂度.png)
 ### 虽然实在同一个时间复杂度 但是还会有常数上的差异


## 快速排序
## 三路快速排序算法
* 之前的快速排序算法都是将序列分成<=v和>v或者是<v和>=v的两个部分，而三路快速排序是
  将序列分成三个部分:<v、=v、>v 进行排序
![三路快速排序算法](https://github.com/Panghu98/algorithm-data-structure/blob/master/三路快速排序p1.png)

  ![三路快速排序算法](/home/panghu/IdeaProjects/Algorithm_And_Data_Structure/picture/三路快速排序算法p2.png)
  
  ![三路快速排序算法](https://github.com/Panghu98/algorithm-data-structure/blob/master/picture/p3.png)

  ![三路快速排序算法](https://github.com/Panghu98/algorithm-data-structure/blob/master/picture/p4.png)
   
  ![三路快速排序算法](https://github.com/Panghu98/algorithm-data-structure/blob/master/picture/p5.png)


 ### 队列
 #### 在静态处理和动态处理（表现很好）的都较好
 * 普通队列：先进先出
 * 优先队列：出队顺序和入队顺序无关；与优先级相关
    * 入队
    * 出队 （去除优先级最高的元素 ）
    ![队列的效率](https://github.com/Panghu98/algorithm-data-structure/blob/master/picture/关于队列的排序算法.png)

    * 二叉堆(必须是一棵完全二叉树):
    [关于二叉树](https://blog.csdn.net/qq_22642239/article/details/80774013)
        *   二叉堆有两种：最大堆和最小堆。
            
            最大堆：父结点的键值总是大于或等于任何一个子结点的键值；
            
            最小堆：父结点的键值总是小于或等于任何一个子节点的键值。
            
            并不意味着层数越高数值越大或者越小  绝对的大小是相对于父节点而言 
    ![完全二叉树](https://github.com/Panghu98/algorithm-data-structure/blob/master/picture/完全二叉树.png)
    
 * 使用数组存储二叉堆
    * 若根结点存在序号0处， i结点的父结点下标就为(i-1)/2。i结点的左右子结点下标分别为2*i+1和2*i+2。
  
 * 堆排序需要解决的问题 
    * 由无序序列建成一个堆
    * 在输出堆顶的元素之后,调整剩余元素成为一个新的堆
 
 ##　排序算法总结
 ![](https://github.com/Panghu98/algorithm-data-structure/blob/master/picture/排序算法总结.png)
 
 ##### 稳定排序：对于相等的元素，在排序后，原来靠前的元素依然靠前，相等元素的相对位置没有发生改变
 ![](/home/panghu/IdeaProjects/Algorithm_And_Data_Structure/picture/Algorithm_stable.png)
 * 排序之后这三个数字的顺序依旧是按照红绿蓝来排序的　（稳定的排序）
 　
 
 # 数据结构 
 ## 数组
 * 数组的最大优点:快速查询
 * 数组最好应用于 索引有语意(素组下表有实际的意义) 的情况
 * 但是并非所有的有语意的索引都适用于数组 
 
 ## 栈
 * 栈是一种线性结构
 * 相比数组,栈对应的操作是数组的子集
 * 只能从一端添加元素,也从一端去除元素
 * 栈是一种后进先出的数据结构
 
 ### 栈的应用
 * 无处不在的Undo操作 (出栈操作)
 * 程序调用的系统栈
 ![](https://github.com/Panghu98/algorithm-data-structure/blob/master/picture/栈的调用.png)
 当B方法调用C方法完毕之后,继续B方法的执行,B方法执行完毕之后 将B方法从系统站出栈
 * 栈的复杂度分析
 ![](https://github.com/Panghu98/algorithm-data-structure/blob/master/picture/栈复杂度分析.png)
  
  ## 队列
  * 队列也是一种线性结构
  * 相比数组,队列对应的操作是数组的子集
  * 只能从队尾添加元素,只能从队首取出元素
  * 队列是一种先进先出的数据结构
  
  ### 数组队列的复杂度分析
  ![](https://github.com/Panghu98/algorithm-data-structure/blob/master/picture/数组队列复杂度分析.png)
  
  ### 循环队列  -- 类似于时钟
  * front == tail队列为空  front指向的是队首,tail指向的是最后一个元素的下一个位置
  * (tail+1)%capacity == front 队列满
  ### 循环队列复杂度分析
  ![](https://github.com/Panghu98/algorithm-data-structure/blob/master/picture/循环队列复杂度分析.png)
  
  ## 小结
  线性数据结构 -- 底层依托静态数组;靠热死则解决固定容量的问题
  * 动态数组
  * 栈
  * 队列
  ### 真正的动态数据结构 -- 链表
  * 优点:真正的动态,不需要处理固定容量的问题
  * 缺点:上市了随机访问的能力
  ### 链表的时间复杂度分析
  ![](https://github.com/Panghu98/algorithm-data-structure/blob/master/picture/链表的时间复杂度分析.png)
  
  
  
  
  
 
 
 
 
    
    
