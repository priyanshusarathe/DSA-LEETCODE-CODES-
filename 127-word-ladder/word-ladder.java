class Solution {

    class Pair {
        String str;
        int step;

        public Pair(String str, int step) {
            this.str = str;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord))
            return 0;

        set.remove(beginWord);

        while (!q.isEmpty()) {

            Pair curr = q.poll();
            String word = curr.str;
            int step = curr.step;

            if (word.equals(endWord)) {
                return step;
            }

            for (int i = 0; i < word.length(); i++) {

                char[] arr = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    arr[i] = ch;
                    String newWord = new String(arr);

                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        q.offer(new Pair(newWord, step + 1));
                    }
                }
            }
        }

        return 0;
    }
}