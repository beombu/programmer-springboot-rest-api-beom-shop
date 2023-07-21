package com.example.beomshop.util;

import java.nio.ByteBuffer;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class JdbcUtil {
    public static UUID toUUID(byte[] bytes) {
      var byteBuffer = ByteBuffer.wrap(bytes);
      return new UUID(byteBuffer.getLong(), byteBuffer.getLong());
    }

    public static byte[] uuidToBytes(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getMostSignificantBits());
        return bb.array();
    }

    public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
      return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}
