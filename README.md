# Stopwatch System
- 자바의 Thread 와 Runnabler 기능을 사용하여 스톱워치 기능을 구현하였습니다.

> #### 기능 설명
- 프로그램 실행 시 시간이 1씩 증가함과 동시에 소요시간을 체크한다.
- 타임 스레드와 입력 스레드가 동시에 동작한다.
- 입력 기능에는 STOP / HOLD / RERUN 이 있다.
  * STOP의 키인 "q"를 입력할 시 타이머 기능과 입력 스레드 동시에 종료하고 소요시간을 출력한다.
  * HOLD의 키인 "h"를 입력할 시 타이머가 정지하며 체크하던 소요시간 체킹도 함께 멈춘다.
  * RERUN의 키인 "a"를 입력할 시 정지한 타이머가 다시 작동하며 소요시간을 다시 카운트 해준다.

> #### Class Diagram
![stopwatch](https://github.com/user-attachments/assets/de1d1426-6702-4287-9111-a668a53c48dc)

> #### Demo
![bandicam-2024-11-13-18-20-51-561](https://github.com/user-attachments/assets/3530aae7-72c9-41db-8253-fddcd6507250)
