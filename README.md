# 자동차 경주 게임
## View

---
### InputView
- [ ] 자동차 이름을 입력 받는다.
  - [ ] 자동차 이름은 5자를 초과할 수 없다.
  - [ ] 자동차 이름은 쉼표를 기준으로 구분한다.
- [ ] 시도 횟수를 입력받는다.


### OutputView
  - [ ] 매 시도 횟수마다 자동차의 상태를 화면에 출력한다.
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지 알려준다.
  - [ ] 우승자는 한 명 이상일 수 있다.

## Domain

---
### Car
- [x] 이름으로 생성한다
- [x] 전진 상태를 가진다
- [x] 시도 횟수 만큼 모든 자동차에 대해 전진 혹은 정지를 판단한다.
  - [x] 값이 4 이상이면 전진한다.

### NumberGenerator (인터페이스)
- [x] 숫자를 생성한다.

### RandomNumberGenerator
- [ ] 0에서 9 사이의 무작위 값을 구한다.

### Referee
- [ ] 누가 우승했는지 판단한다.
  - [ ] 차 리스트를 받아서 이동 거리가 긴 사람을 판단한다.
