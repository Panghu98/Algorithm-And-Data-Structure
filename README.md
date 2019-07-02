 # 算法
 ## 排序算法
 ### 各种排序算法的时间复杂度
 ![时间复杂度](/home/panghu/IdeaProjects/Algorithm_And_Data_Structure/picture/时间复杂度.png)
 ### 虽然实在同一个时间复杂度 但是还会有常数上的差异


快速排序
![快速排序](/home/panghu/IdeaProjects/Algorithm_And_Data_Structure/picture/快速排序.png)


 ### 队列
 #### 在静态处理和动态处理（表现很好）的都较好
 * 普通队列：先进先出
 * 优先队列：出队顺序和入队顺序无关；与优先级相关
    * 入队
    * 出队 （去除优先级最高的元素 ）
    ![队列的效率](/home/panghu/IdeaProjects/Algorithm_And_Data_Structure/picture/关于队列的排序算法.png)

    * 二叉堆(必须是一棵完全二叉树):
    [关于二叉树](https://blog.csdn.net/qq_22642239/article/details/80774013)
        *   二叉堆有两种：最大堆和最小堆。
            
            最大堆：父结点的键值总是大于或等于任何一个子结点的键值；
            
            最小堆：父结点的键值总是小于或等于任何一个子节点的键值。
            
            并不意味着层数越高数值越大或者越小  绝对的大小是相对于父节点而言 
    ![完全二叉树](/home/panghu/IdeaProjects/Algorithm_And_Data_Structure/picture/完全二叉树.png)
    
 * 使用数组存储二叉堆
    * 若根结点存在序号0处， i结点的父结点下标就为(i-1)/2。i结点的左右子结点下标分别为2*i+1和2*i+2。
  
 * 堆排序需要解决的问题 
    * 由无序序列建成一个堆
    * 在输出堆顶的元素之后,调整剩余元素成为一个新的堆
 
 ##　排序算法总结
 ![](/home/panghu/IdeaProjects/Algorithm_And_Data_Structure/picture/排序算法总结.png)
 
 ##### 稳定排序：对于相等的元素，在排序后，原来靠前的元素依然靠前，相等元素的相对位置没有发生改变
 ![](/home/panghu/IdeaProjects/Algorithm_And_Data_Structure/picture/Algorithm_stable.png)
 * 排序之后这三个数字的顺序依旧是按照红绿蓝来排序的　（稳定的排序）
 　
 
 # 数据结构 
 ## 数组
 * 数组的最大优点:快速查询
 * 数组最好应用于 索引有语意(素组下表有实际的意义) 的情况
 * 但是并非所有的有语意的索引都适用于数组 
 
    
    