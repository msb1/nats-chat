package com.demo.chat.protobuf;// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: event.proto

public final class Event {
  private Event() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code sport}
   */
  public enum sport
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>BASEBALL = 1;</code>
     */
    BASEBALL(1),
    /**
     * <code>BASKETBALL = 2;</code>
     */
    BASKETBALL(2),
    /**
     * <code>FOOTBALL = 3;</code>
     */
    FOOTBALL(3),
    /**
     * <code>BOXING = 4;</code>
     */
    BOXING(4),
    /**
     * <code>GOLF = 5;</code>
     */
    GOLF(5),
    /**
     * <code>NASCAR = 6;</code>
     */
    NASCAR(6),
    /**
     * <code>TENNIS = 7;</code>
     */
    TENNIS(7),
    ;

    /**
     * <code>BASEBALL = 1;</code>
     */
    public static final int BASEBALL_VALUE = 1;
    /**
     * <code>BASKETBALL = 2;</code>
     */
    public static final int BASKETBALL_VALUE = 2;
    /**
     * <code>FOOTBALL = 3;</code>
     */
    public static final int FOOTBALL_VALUE = 3;
    /**
     * <code>BOXING = 4;</code>
     */
    public static final int BOXING_VALUE = 4;
    /**
     * <code>GOLF = 5;</code>
     */
    public static final int GOLF_VALUE = 5;
    /**
     * <code>NASCAR = 6;</code>
     */
    public static final int NASCAR_VALUE = 6;
    /**
     * <code>TENNIS = 7;</code>
     */
    public static final int TENNIS_VALUE = 7;


    public final int getNumber() {
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static sport valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static sport forNumber(int value) {
      switch (value) {
        case 1: return BASEBALL;
        case 2: return BASKETBALL;
        case 3: return FOOTBALL;
        case 4: return BOXING;
        case 5: return GOLF;
        case 6: return NASCAR;
        case 7: return TENNIS;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<sport>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        sport> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<sport>() {
            public sport findValueByNumber(int number) {
              return sport.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return Event.getDescriptor().getEnumTypes().get(0);
    }

    private static final sport[] VALUES = values();

    public static sport valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private sport(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:sport)
  }

  public interface eventOrBuilder extends
      // @@protoc_insertion_point(interface_extends:event)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required .sport sport = 1;</code>
     * @return Whether the sport field is set.
     */
    boolean hasSport();
    /**
     * <code>required .sport sport = 1;</code>
     * @return The sport.
     */
    Event.sport getSport();

    /**
     * <code>required string match_title = 2;</code>
     * @return Whether the matchTitle field is set.
     */
    boolean hasMatchTitle();
    /**
     * <code>required string match_title = 2;</code>
     * @return The matchTitle.
     */
    java.lang.String getMatchTitle();
    /**
     * <code>required string match_title = 2;</code>
     * @return The bytes for matchTitle.
     */
    com.google.protobuf.ByteString
        getMatchTitleBytes();

    /**
     * <code>required string data_event = 3;</code>
     * @return Whether the dataEvent field is set.
     */
    boolean hasDataEvent();
    /**
     * <code>required string data_event = 3;</code>
     * @return The dataEvent.
     */
    java.lang.String getDataEvent();
    /**
     * <code>required string data_event = 3;</code>
     * @return The bytes for dataEvent.
     */
    com.google.protobuf.ByteString
        getDataEventBytes();
  }
  /**
   * Protobuf type {@code event}
   */
  public static final class event extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:event)
      eventOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use event.newBuilder() to construct.
    private event(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private event() {
      sport_ = 1;
      matchTitle_ = "";
      dataEvent_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new event();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private event(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              int rawValue = input.readEnum();
                @SuppressWarnings("deprecation")
              Event.sport value = Event.sport.valueOf(rawValue);
              if (value == null) {
                unknownFields.mergeVarintField(1, rawValue);
              } else {
                bitField0_ |= 0x00000001;
                sport_ = rawValue;
              }
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              matchTitle_ = bs;
              break;
            }
            case 26: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000004;
              dataEvent_ = bs;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Event.internal_static_event_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Event.internal_static_event_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Event.event.class, Event.event.Builder.class);
    }

    private int bitField0_;
    public static final int SPORT_FIELD_NUMBER = 1;
    private int sport_;
    /**
     * <code>required .sport sport = 1;</code>
     * @return Whether the sport field is set.
     */
    @java.lang.Override public boolean hasSport() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required .sport sport = 1;</code>
     * @return The sport.
     */
    @java.lang.Override public Event.sport getSport() {
      @SuppressWarnings("deprecation")
      Event.sport result = Event.sport.valueOf(sport_);
      return result == null ? Event.sport.BASEBALL : result;
    }

    public static final int MATCH_TITLE_FIELD_NUMBER = 2;
    private volatile java.lang.Object matchTitle_;
    /**
     * <code>required string match_title = 2;</code>
     * @return Whether the matchTitle field is set.
     */
    @java.lang.Override
    public boolean hasMatchTitle() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>required string match_title = 2;</code>
     * @return The matchTitle.
     */
    @java.lang.Override
    public java.lang.String getMatchTitle() {
      java.lang.Object ref = matchTitle_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          matchTitle_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string match_title = 2;</code>
     * @return The bytes for matchTitle.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getMatchTitleBytes() {
      java.lang.Object ref = matchTitle_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        matchTitle_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DATA_EVENT_FIELD_NUMBER = 3;
    private volatile java.lang.Object dataEvent_;
    /**
     * <code>required string data_event = 3;</code>
     * @return Whether the dataEvent field is set.
     */
    @java.lang.Override
    public boolean hasDataEvent() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>required string data_event = 3;</code>
     * @return The dataEvent.
     */
    @java.lang.Override
    public java.lang.String getDataEvent() {
      java.lang.Object ref = dataEvent_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          dataEvent_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string data_event = 3;</code>
     * @return The bytes for dataEvent.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getDataEventBytes() {
      java.lang.Object ref = dataEvent_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dataEvent_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasSport()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasMatchTitle()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasDataEvent()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) != 0)) {
        output.writeEnum(1, sport_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, matchTitle_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, dataEvent_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, sport_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, matchTitle_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, dataEvent_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Event.event)) {
        return super.equals(obj);
      }
      Event.event other = (Event.event) obj;

      if (hasSport() != other.hasSport()) return false;
      if (hasSport()) {
        if (sport_ != other.sport_) return false;
      }
      if (hasMatchTitle() != other.hasMatchTitle()) return false;
      if (hasMatchTitle()) {
        if (!getMatchTitle()
            .equals(other.getMatchTitle())) return false;
      }
      if (hasDataEvent() != other.hasDataEvent()) return false;
      if (hasDataEvent()) {
        if (!getDataEvent()
            .equals(other.getDataEvent())) return false;
      }
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasSport()) {
        hash = (37 * hash) + SPORT_FIELD_NUMBER;
        hash = (53 * hash) + sport_;
      }
      if (hasMatchTitle()) {
        hash = (37 * hash) + MATCH_TITLE_FIELD_NUMBER;
        hash = (53 * hash) + getMatchTitle().hashCode();
      }
      if (hasDataEvent()) {
        hash = (37 * hash) + DATA_EVENT_FIELD_NUMBER;
        hash = (53 * hash) + getDataEvent().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Event.event parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Event.event parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Event.event parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Event.event parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Event.event parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Event.event parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Event.event parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Event.event parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Event.event parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Event.event parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Event.event parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Event.event parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Event.event prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code event}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:event)
        Event.eventOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Event.internal_static_event_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Event.internal_static_event_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Event.event.class, Event.event.Builder.class);
      }

      // Construct using Event.event.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        sport_ = 1;
        bitField0_ = (bitField0_ & ~0x00000001);
        matchTitle_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        dataEvent_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Event.internal_static_event_descriptor;
      }

      @java.lang.Override
      public Event.event getDefaultInstanceForType() {
        return Event.event.getDefaultInstance();
      }

      @java.lang.Override
      public Event.event build() {
        Event.event result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public Event.event buildPartial() {
        Event.event result = new Event.event(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          to_bitField0_ |= 0x00000001;
        }
        result.sport_ = sport_;
        if (((from_bitField0_ & 0x00000002) != 0)) {
          to_bitField0_ |= 0x00000002;
        }
        result.matchTitle_ = matchTitle_;
        if (((from_bitField0_ & 0x00000004) != 0)) {
          to_bitField0_ |= 0x00000004;
        }
        result.dataEvent_ = dataEvent_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Event.event) {
          return mergeFrom((Event.event)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Event.event other) {
        if (other == Event.event.getDefaultInstance()) return this;
        if (other.hasSport()) {
          setSport(other.getSport());
        }
        if (other.hasMatchTitle()) {
          bitField0_ |= 0x00000002;
          matchTitle_ = other.matchTitle_;
          onChanged();
        }
        if (other.hasDataEvent()) {
          bitField0_ |= 0x00000004;
          dataEvent_ = other.dataEvent_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        if (!hasSport()) {
          return false;
        }
        if (!hasMatchTitle()) {
          return false;
        }
        if (!hasDataEvent()) {
          return false;
        }
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Event.event parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Event.event) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int sport_ = 1;
      /**
       * <code>required .sport sport = 1;</code>
       * @return Whether the sport field is set.
       */
      @java.lang.Override public boolean hasSport() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>required .sport sport = 1;</code>
       * @return The sport.
       */
      @java.lang.Override
      public Event.sport getSport() {
        @SuppressWarnings("deprecation")
        Event.sport result = Event.sport.valueOf(sport_);
        return result == null ? Event.sport.BASEBALL : result;
      }
      /**
       * <code>required .sport sport = 1;</code>
       * @param value The sport to set.
       * @return This builder for chaining.
       */
      public Builder setSport(Event.sport value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        sport_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>required .sport sport = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearSport() {
        bitField0_ = (bitField0_ & ~0x00000001);
        sport_ = 1;
        onChanged();
        return this;
      }

      private java.lang.Object matchTitle_ = "";
      /**
       * <code>required string match_title = 2;</code>
       * @return Whether the matchTitle field is set.
       */
      public boolean hasMatchTitle() {
        return ((bitField0_ & 0x00000002) != 0);
      }
      /**
       * <code>required string match_title = 2;</code>
       * @return The matchTitle.
       */
      public java.lang.String getMatchTitle() {
        java.lang.Object ref = matchTitle_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            matchTitle_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string match_title = 2;</code>
       * @return The bytes for matchTitle.
       */
      public com.google.protobuf.ByteString
          getMatchTitleBytes() {
        java.lang.Object ref = matchTitle_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          matchTitle_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string match_title = 2;</code>
       * @param value The matchTitle to set.
       * @return This builder for chaining.
       */
      public Builder setMatchTitle(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        matchTitle_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string match_title = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearMatchTitle() {
        bitField0_ = (bitField0_ & ~0x00000002);
        matchTitle_ = getDefaultInstance().getMatchTitle();
        onChanged();
        return this;
      }
      /**
       * <code>required string match_title = 2;</code>
       * @param value The bytes for matchTitle to set.
       * @return This builder for chaining.
       */
      public Builder setMatchTitleBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        matchTitle_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object dataEvent_ = "";
      /**
       * <code>required string data_event = 3;</code>
       * @return Whether the dataEvent field is set.
       */
      public boolean hasDataEvent() {
        return ((bitField0_ & 0x00000004) != 0);
      }
      /**
       * <code>required string data_event = 3;</code>
       * @return The dataEvent.
       */
      public java.lang.String getDataEvent() {
        java.lang.Object ref = dataEvent_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            dataEvent_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string data_event = 3;</code>
       * @return The bytes for dataEvent.
       */
      public com.google.protobuf.ByteString
          getDataEventBytes() {
        java.lang.Object ref = dataEvent_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          dataEvent_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string data_event = 3;</code>
       * @param value The dataEvent to set.
       * @return This builder for chaining.
       */
      public Builder setDataEvent(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        dataEvent_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string data_event = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearDataEvent() {
        bitField0_ = (bitField0_ & ~0x00000004);
        dataEvent_ = getDefaultInstance().getDataEvent();
        onChanged();
        return this;
      }
      /**
       * <code>required string data_event = 3;</code>
       * @param value The bytes for dataEvent to set.
       * @return This builder for chaining.
       */
      public Builder setDataEventBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        dataEvent_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:event)
    }

    // @@protoc_insertion_point(class_scope:event)
    private static final Event.event DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Event.event();
    }

    public static Event.event getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<event>
        PARSER = new com.google.protobuf.AbstractParser<event>() {
      @java.lang.Override
      public event parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new event(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<event> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<event> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public Event.event getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_event_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_event_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013event.proto\"G\n\005event\022\025\n\005sport\030\001 \002(\0162\006." +
      "sport\022\023\n\013match_title\030\002 \002(\t\022\022\n\ndata_event" +
      "\030\003 \002(\t*a\n\005sport\022\014\n\010BASEBALL\020\001\022\016\n\nBASKETB" +
      "ALL\020\002\022\014\n\010FOOTBALL\020\003\022\n\n\006BOXING\020\004\022\010\n\004GOLF\020" +
      "\005\022\n\n\006NASCAR\020\006\022\n\n\006TENNIS\020\007"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_event_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_event_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_event_descriptor,
        new java.lang.String[] { "Sport", "MatchTitle", "DataEvent", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
