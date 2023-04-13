package hello.advanced.trace;

import java.util.UUID;

public class TraceId {

    private String id;  // 트랜잭션 id
    private int level;  // 트랜잭션의 깊이


    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }


    // 생성된 UUID 를 8자리만 잘라서 사용
    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    // 다음 단계의  깊이를 가진 TraceId 를 생성
    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    // 이전 단계의 깊이를 가진 TraceId 를 생성
    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }
    public String getId() {
        return id;
    }
    public int getLevel() {
        return level;
    }

}
