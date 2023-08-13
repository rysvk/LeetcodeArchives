class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 || j >= 0 || carry ==1){
            carry += (i >= 0 ? a.charAt(i--) - '0' : 0) +
                      (j >= 0 ? b.charAt(j--) - '0' : 0);
            result.append(carry % 2);
            carry >>= 1;
        }
        return result.reverse().toString();
    }
}