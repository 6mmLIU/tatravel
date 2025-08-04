package cn.wolfcode.wolf2w.business.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoteCondition {
    private int min;
    private int max;
    public static final Map<Integer, NoteCondition> TIME_MAP = new HashMap<>();
    public static final Map<Integer, NoteCondition> DAY_MAP = new HashMap<>();
    public static final Map<Integer, NoteCondition> CONSUME_MAP = new HashMap<>();

    static {
        TIME_MAP.put(1, new NoteCondition(1, 2));
        TIME_MAP.put(2, new NoteCondition(3, 4));
        TIME_MAP.put(3, new NoteCondition(5, 6));
        TIME_MAP.put(4, new NoteCondition(7, 8));
        TIME_MAP.put(5, new NoteCondition(9, 10));
        TIME_MAP.put(6, new NoteCondition(11, 12));

        DAY_MAP.put(1, new NoteCondition(1, 3));
        DAY_MAP.put(2, new NoteCondition(4, 7));
        DAY_MAP.put(3, new NoteCondition(8, 14));
        DAY_MAP.put(4, new NoteCondition(15, Integer.MAX_VALUE));


        CONSUME_MAP.put(1, new NoteCondition(1, 999));
        CONSUME_MAP.put(2, new NoteCondition(1000, 5999));
        CONSUME_MAP.put(3, new NoteCondition(6000, 19999));
        CONSUME_MAP.put(4, new NoteCondition(20000, Integer.MAX_VALUE));

    }
}
