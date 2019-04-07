/*
1. 암호를 깨기 (cracking)하기 위해 사전(dictionary)은 큰 도움이 된다. 여기서는 한글
단어가 주어지면 이를 영문으로 변환하는 프로그램을 작성하시오. 
[예] toeng 한글비번
[결과] gksrmfqlqjs

2. 영자 중에 숫자와 모양이 비슷한 경우나 숫자에서 Shift를 누른 후의 해당 특수문자
를 비밀번호로 사용하는 경우가 빈번히 있다. 다음과 같이 간단히 주어진 비밀번호에
대해 변환하는 프로그램을 작성하시오. 
[변환 테이블]
영소문자 엘 (l) -> 1
영소문자 오 (o) -> 0
각 숫자 “0123456789” -> “)!@#$%^&*(”
[입력 예] tospecial ablol2019
[출력 예] ab101@)!(

3. crunch라는 도구는 주어진 char를 조합하여 도움을 준다. 우리는 char단위가 아닌
단어 단위의 조합을 구하고자 한다.
* 명령어는 crunchword [min조합개수] [max조합개수] [단어리스트 ...]
[입력 예] crunchword 2 3“2010”“6435” “naver”
[결과 예] “20106435”“2010naver”“64352010”“6435naver”“naver2010”
“naver6435”“20106435naver”“2010naver6435”“64352010naver”“6435naver20
10” “naver20106435”“naver64352010”
*/

public class Main {
    public static void main(String[] args) {
        
    }
}