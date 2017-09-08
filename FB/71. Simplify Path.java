That is silly but naive way.

class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return new String();
        }
        char[] array = path.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        if (array[0] != '/') {
            return new String();
        }
        int i = 0;
        while (i < array.length) {
            if (i < array.length - 2 && array[i + 1] == '.' && array[i + 2] == '.' && (i + 3 == array.length
                                                                                        || array[i + 3] == '/')) {
               if (!stack.isEmpty()) {
                   while (stack.peekFirst() != '/') {
                       stack.pollFirst();
                   }
                   stack.pollFirst();
               }
                i = i + 3;
            } else if (i < array.length - 1 && array[i + 1] == '.' && (i + 2 == array.length || array[i + 2] == '/')) {
                i = i + 2;
            } else {
                if (i < array.length - 1 && array[i + 1] != '/') {
                    stack.offerFirst(array[i++]);
                    while (i < array.length && array[i] != '/') {
                        stack.offerFirst(array[i++]);
                    }
                } else {
                    i++;
                }
            }
        }
        if (stack.isEmpty()) {
        	return new String("/");
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}




Split the content, and we will have three content to pay attention (".", "..", "")
"." and "", do not make any action.
".." pop


class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
            return new String();
        }
        Deque<String> stack = new LinkedList<>();
        String[] str = path.split("/");
        Set<String> set = new HashSet<>();
        set.add(".");
        set.add("..");
        set.add("");
        for (String s : str) {
            if (s.equals("..") && !stack.isEmpty()) {
                stack.pollFirst();
            } else if (!set.contains(s)) {
                stack.offerFirst(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            return new String("/");
        }
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
