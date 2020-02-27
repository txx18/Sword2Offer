package linkedList;


import zhelper.ListUtils.*;

import java.util.LinkedList;
import java.util.List;

/**
 * 打印有序链表的公共部分
 *
 * @author Shane Tang
 * @create 2019-10-04 10:35
 */
public class CommonPartOfOrderedLists {

    public List<Integer> printCommonPartOfOrderedLists(ListNode head1, ListNode head2) {
        List<Integer> res = new LinkedList<>();
        while (head1 != null && head2 != null){
            // 相等就记录下来
            if(head1.val == head2.val){
                res.add(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
            // 谁小谁移动（类似归并排序）
            else if(head1.val < head2.val){
                head1 = head1.next;
            }else if(head2.val < head1.val){
                head2 = head2.next;
            }
        }
        return res;
    }

}
