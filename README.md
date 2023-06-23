# kotlin-minesweeper
## 기능 요구사항
- 높이와 너비, 지뢰 개수를 입력받을 수 있다.
- 지뢰는 눈에 잘 띄는 것으로 표기한다.
- 지뢰는 가급적 랜덤에 가깝게 배치한다.

- [x] 2차원 배열 객체를 가진다.
  - [x] 높이,너비,라인 일급 컬렉션 프로퍼티를 가진다.
  - [x] 전체 좌표를 순회하며 지뢰를 심을 수 있다. 
- [x] 높이 객체를 가진다.
- [x] 너비 객체를 가진다.
- [x] 위치 정보 객체를 가진다. 
- [x] 심볼 열거 타입을 가진다.
- [x] 위치 정보 일급 컬렉션 라인(Line) 객체를 가진다.
- [x] 라인 일급 컬렉션(Lines) 을 가진다.

- [x] 지뢰 생성 전략 인터페이스를 가진다.
  - [x] 생성 기능을 정의한다.
  - [x] 지뢰 생성 전략 구현체를 가진다.
- [x] 지뢰찾기 서비스를 가진다. 
  - [x] 지뢰판 생성 기능을 제공한다.
- [x] 지뢰찾기 컨트롤러를 가진다. 
- [x] 지뢰 찾기 I/O를 가진다. 
  - [x] 지뢰 찾기 게임 Input 객체를 가진다.
    - [x] 높이 질문을 할 수 있다
    - [x] 너비 질문을 할 수 있다
    - [x] 지뢰 갯수 질문을 할 수 있다
  - [x] 지뢰 찾기 게임 Output 객체를 가진다.
    - [x] 지뢰판 정보를 출력할 수 있다. 
- [x] 지뢰 찾기 프록시 객체를 가진다.
  - [x] 지뢰 찾기 게임 Input 객체를 프로퍼티로 가진다.
  - [x] 공백이나 숫자가 아닌 경우 안내 메세지 제공 후 재시도를 한다.

## 프로그래밍 요구 사항
- 객체지향 생활 체조 원칙을 지키면서 프로그래밍한다.
### 객체지향 생활 체조 원칙
- 한 메서드에 오직 한 단계의 들여쓰기만 한다.
- else 예약어를 쓰지 않는다.
- 모든 원시 값과 문자열을 포장한다.
- 한 줄에 점을 하나만 찍는다.
- 줄여 쓰지 않는다(축약 금지).
- 모든 엔티티를 작게 유지한다.
- 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
- 일급 컬렉션을 쓴다.
- getter/setter/프로퍼티를 쓰지 않는다.

## 실행 결과
```text
높이를 입력하세요.
10

너비를 입력하세요.
10

지뢰는 몇 개인가요?
10

지뢰찾기 게임 시작
C C C * C C C * C C
C C * C * C C C C C
C C C C C C C C C C
C C C C C C C C C C
* C C C C C C C C C
C C C C C C * C C C
C C * C C C * C C C
C C C C C C * C C *
C C C C C C C C C C
C C C C C C C C C C
```
