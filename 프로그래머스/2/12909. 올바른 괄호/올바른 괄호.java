import java.util.*;

class Solution {
    public boolean solution(String s) {
        // 스택 생성
        Stack<Character> stack = new Stack<>();
        
        // 문자열 s를 한 글자씩 순회
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c); // '('를 만나면 스택에 push(삽입)
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false; // 스택이 비어있거나 pop한 값이 '('이 아니면 false 반환
                }
            }
        }
        
        // 모든 문자열을 순회한 후에도 스택이 비어있어야 올바른 괄호
        return stack.isEmpty();
    }
}