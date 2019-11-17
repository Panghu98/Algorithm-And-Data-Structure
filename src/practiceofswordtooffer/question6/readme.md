## 题目
输入同一个链表的头结点，从头到尾范国磊打印出每一个节点的值

## 思路
- 递归函数
- 利用栈进行倒置


## 生成单项链表有两种方式

### 头插法
![](https://img-blog.csdn.net/20180926181043191?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMDI4OTg1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
```
Linklist Creat_list(Linklist head) {
	head = (Linklist)malloc(sizeof(Lnode));      //  为头指针开辟内存空间
	Lnode *node = NULL;                    //  定义新结点
	int count = 0;                          //  创建结点的个数
	head->next = NULL;              
	node = head->next;              	//  将最后一个结点的指针域永远保持为NULL
	printf("Input the node number: ");
	scanf("%d", &count);
	for (int i = 0; i < count; i++) {
		node = (Linklist)malloc(sizeof(Lnode));     //  为新结点开辟内存空间
		node->data = i;               //  为新结点的数据域赋值
		node->next = head->next;          //  将头指针所指向的下一个结点的地址，赋给新创建结点的next 
		head->next = node;          //  将新创建的结点的地址赋给头指针的下一个结点
	}
	return head;
}
```

### 尾插法
![](https://img-blog.csdn.net/20180926194847575?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMDI4OTg1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
```
Linklist Creat_list(Linklist head) {
	head = (Linklist)malloc(sizeof(Lnode));          //  为头指针开辟内存空间
	Linklist node = NULL;           //  定义结点
	Linklist end = NULL;            //  定义尾结点
	head->next = NULL;              //  初始化头结点指向的下一个地址为 NULL
	end = head;                     //  未创建其余结点之前，只有一个头结点
	int count = 0 ;                 //  结点个数
	printf("Input node number: ");
	scanf("%d", &count);
	for (int i = 0; i < count; i++) {
		node = (Linklist)malloc(sizeof(Lnode));          //  为新结点开辟新内存
		node->data = i;                                  //  新结点的数据域赋值
		end->next = node;                      		
		end = node;
	}
	end->next = NULL;
}
```