class Solution {
    public int lengthOfLastWord(String s) {
        int lastWordEnd = s.length() - 1;
        while (lastWordEnd >= 0 && s.charAt(lastWordEnd) == ' ')
            lastWordEnd --;
        int lastWordStart = lastWordEnd;
        while (lastWordStart >= 0 && s.charAt(lastWordStart) != ' ')
            lastWordStart --;
        return lastWordEnd - lastWordStart;
    }
}