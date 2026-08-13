class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int len;
        int pre;
        int suf;
        int best;

        Node(char ch) {
            leftChar = ch;
            rightChar = ch;
            len = 1;
            pre = 1;
            suf = 1;
            best = 1;
        }

        Node() {}
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        int n = s.length();

        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            arr[index] = ch;

            update(1, 0, n - 1, index, ch);

            ans[i] = tree[1].best;
        }

        return ans;
    }



    void build(int node, int l, int r) {

        if (l == r) {
            tree[node] = new Node(arr[l]);
            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
        );
    }



    void update(int node, int l, int r, int index, char ch) {

        if (l == r) {
            tree[node] = new Node(ch);
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, r, index, ch);
        }

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
        );
    }


    Node merge(Node a, Node b) {

        Node res = new Node();

        res.len = a.len + b.len;

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

      
        res.pre = a.pre;

       
  
    
        if (a.pre == a.len && a.rightChar == b.leftChar) {
            res.pre = a.len + b.pre;
        }

        res.suf = b.suf;

   
        if (b.suf == b.len && a.rightChar == b.leftChar) {
            res.suf = b.len + a.suf;
        }

      
        res.best = Math.max(a.best, b.best);

    
        if (a.rightChar == b.leftChar) {
            res.best = Math.max(
                    res.best,
                    a.suf + b.pre
            );
        }

        return res;
    }
}