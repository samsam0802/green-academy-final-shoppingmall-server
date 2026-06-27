## 화장품 쇼핑몰 프로젝트

### 배포
기존 AWS EC2에서 비용 문제로 Render로 전환하였습니다.
배포 주소 : https://www.moisture-village.shop/

### 주요 구현 기능
장바구니, 주문/결제, 관리자 주문 내역 검색, 주문 상태 관리 기능을 구현하였습니다.

### 기술적 개선 사항
주문 내역 조회 쿼리를 EXPLAIN ANALYZE로 분석한 결과, orders와 order_products 
테이블에서 Seq Scan이 발생하는 것을 확인했습니다.
user_id, is_deleted, created_at 복합 인덱스와 order_id 인덱스를 추가한 결과, 
조회 실행 시간이 6.6ms → 0.6ms로 약 11배 개선되었습니다.

### 기술 스택
프론트엔드 : Javascript, React, Vite, Redux, HTML, CSS, TailwindCSS
백엔드 : Spring Boot, Java, QueryDSL
DB : MySQL -> PostgreSQL, AWS RDS -> Render Postgres
배포 : AWS EC2 -> Render, AWS S3 -> Cloudinary, Vercel
개발 도구 : Visual Studio Code, IntelliJ
협업 도구 : GitHub, GitKraken, Discord
크롤링 도구 : Python, PyCharm
