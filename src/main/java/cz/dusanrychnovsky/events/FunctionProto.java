// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: function.proto

package cz.dusanrychnovsky.events;

public final class FunctionProto {
  private FunctionProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface FunctionOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Function)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required .EventType type = 1;</code>
     */
    boolean hasType();
    /**
     * <code>required .EventType type = 1;</code>
     */
    cz.dusanrychnovsky.events.EventProto.EventType getType();

    /**
     * <code>required string operation = 2;</code>
     */
    boolean hasOperation();
    /**
     * <code>required string operation = 2;</code>
     */
    java.lang.String getOperation();
    /**
     * <code>required string operation = 2;</code>
     */
    com.google.protobuf.ByteString
        getOperationBytes();
  }
  /**
   * Protobuf type {@code Function}
   */
  public  static final class Function extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Function)
      FunctionOrBuilder {
    // Use Function.newBuilder() to construct.
    private Function(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Function() {
      type_ = 1;
      operation_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Function(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
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
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              int rawValue = input.readEnum();
              cz.dusanrychnovsky.events.EventProto.EventType value = cz.dusanrychnovsky.events.EventProto.EventType.valueOf(rawValue);
              if (value == null) {
                unknownFields.mergeVarintField(1, rawValue);
              } else {
                bitField0_ |= 0x00000001;
                type_ = rawValue;
              }
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              operation_ = bs;
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
      return cz.dusanrychnovsky.events.FunctionProto.internal_static_Function_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cz.dusanrychnovsky.events.FunctionProto.internal_static_Function_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cz.dusanrychnovsky.events.FunctionProto.Function.class, cz.dusanrychnovsky.events.FunctionProto.Function.Builder.class);
    }

    private int bitField0_;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int type_;
    /**
     * <code>required .EventType type = 1;</code>
     */
    public boolean hasType() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required .EventType type = 1;</code>
     */
    public cz.dusanrychnovsky.events.EventProto.EventType getType() {
      cz.dusanrychnovsky.events.EventProto.EventType result = cz.dusanrychnovsky.events.EventProto.EventType.valueOf(type_);
      return result == null ? cz.dusanrychnovsky.events.EventProto.EventType.OrderCreated : result;
    }

    public static final int OPERATION_FIELD_NUMBER = 2;
    private volatile java.lang.Object operation_;
    /**
     * <code>required string operation = 2;</code>
     */
    public boolean hasOperation() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string operation = 2;</code>
     */
    public java.lang.String getOperation() {
      java.lang.Object ref = operation_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          operation_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string operation = 2;</code>
     */
    public com.google.protobuf.ByteString
        getOperationBytes() {
      java.lang.Object ref = operation_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        operation_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasType()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasOperation()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeEnum(1, type_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, operation_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, type_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, operation_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof cz.dusanrychnovsky.events.FunctionProto.Function)) {
        return super.equals(obj);
      }
      cz.dusanrychnovsky.events.FunctionProto.Function other = (cz.dusanrychnovsky.events.FunctionProto.Function) obj;

      boolean result = true;
      result = result && (hasType() == other.hasType());
      if (hasType()) {
        result = result && type_ == other.type_;
      }
      result = result && (hasOperation() == other.hasOperation());
      if (hasOperation()) {
        result = result && getOperation()
            .equals(other.getOperation());
      }
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasType()) {
        hash = (37 * hash) + TYPE_FIELD_NUMBER;
        hash = (53 * hash) + type_;
      }
      if (hasOperation()) {
        hash = (37 * hash) + OPERATION_FIELD_NUMBER;
        hash = (53 * hash) + getOperation().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static cz.dusanrychnovsky.events.FunctionProto.Function parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static cz.dusanrychnovsky.events.FunctionProto.Function parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static cz.dusanrychnovsky.events.FunctionProto.Function parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static cz.dusanrychnovsky.events.FunctionProto.Function parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static cz.dusanrychnovsky.events.FunctionProto.Function parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static cz.dusanrychnovsky.events.FunctionProto.Function parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static cz.dusanrychnovsky.events.FunctionProto.Function parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static cz.dusanrychnovsky.events.FunctionProto.Function parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static cz.dusanrychnovsky.events.FunctionProto.Function parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static cz.dusanrychnovsky.events.FunctionProto.Function parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(cz.dusanrychnovsky.events.FunctionProto.Function prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
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
     * Protobuf type {@code Function}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Function)
        cz.dusanrychnovsky.events.FunctionProto.FunctionOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return cz.dusanrychnovsky.events.FunctionProto.internal_static_Function_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return cz.dusanrychnovsky.events.FunctionProto.internal_static_Function_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                cz.dusanrychnovsky.events.FunctionProto.Function.class, cz.dusanrychnovsky.events.FunctionProto.Function.Builder.class);
      }

      // Construct using cz.dusanrychnovsky.events.FunctionProto.Function.newBuilder()
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
      public Builder clear() {
        super.clear();
        type_ = 1;
        bitField0_ = (bitField0_ & ~0x00000001);
        operation_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return cz.dusanrychnovsky.events.FunctionProto.internal_static_Function_descriptor;
      }

      public cz.dusanrychnovsky.events.FunctionProto.Function getDefaultInstanceForType() {
        return cz.dusanrychnovsky.events.FunctionProto.Function.getDefaultInstance();
      }

      public cz.dusanrychnovsky.events.FunctionProto.Function build() {
        cz.dusanrychnovsky.events.FunctionProto.Function result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public cz.dusanrychnovsky.events.FunctionProto.Function buildPartial() {
        cz.dusanrychnovsky.events.FunctionProto.Function result = new cz.dusanrychnovsky.events.FunctionProto.Function(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.type_ = type_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.operation_ = operation_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof cz.dusanrychnovsky.events.FunctionProto.Function) {
          return mergeFrom((cz.dusanrychnovsky.events.FunctionProto.Function)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(cz.dusanrychnovsky.events.FunctionProto.Function other) {
        if (other == cz.dusanrychnovsky.events.FunctionProto.Function.getDefaultInstance()) return this;
        if (other.hasType()) {
          setType(other.getType());
        }
        if (other.hasOperation()) {
          bitField0_ |= 0x00000002;
          operation_ = other.operation_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasType()) {
          return false;
        }
        if (!hasOperation()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        cz.dusanrychnovsky.events.FunctionProto.Function parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (cz.dusanrychnovsky.events.FunctionProto.Function) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int type_ = 1;
      /**
       * <code>required .EventType type = 1;</code>
       */
      public boolean hasType() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required .EventType type = 1;</code>
       */
      public cz.dusanrychnovsky.events.EventProto.EventType getType() {
        cz.dusanrychnovsky.events.EventProto.EventType result = cz.dusanrychnovsky.events.EventProto.EventType.valueOf(type_);
        return result == null ? cz.dusanrychnovsky.events.EventProto.EventType.OrderCreated : result;
      }
      /**
       * <code>required .EventType type = 1;</code>
       */
      public Builder setType(cz.dusanrychnovsky.events.EventProto.EventType value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        type_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>required .EventType type = 1;</code>
       */
      public Builder clearType() {
        bitField0_ = (bitField0_ & ~0x00000001);
        type_ = 1;
        onChanged();
        return this;
      }

      private java.lang.Object operation_ = "";
      /**
       * <code>required string operation = 2;</code>
       */
      public boolean hasOperation() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string operation = 2;</code>
       */
      public java.lang.String getOperation() {
        java.lang.Object ref = operation_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            operation_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string operation = 2;</code>
       */
      public com.google.protobuf.ByteString
          getOperationBytes() {
        java.lang.Object ref = operation_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          operation_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string operation = 2;</code>
       */
      public Builder setOperation(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        operation_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string operation = 2;</code>
       */
      public Builder clearOperation() {
        bitField0_ = (bitField0_ & ~0x00000002);
        operation_ = getDefaultInstance().getOperation();
        onChanged();
        return this;
      }
      /**
       * <code>required string operation = 2;</code>
       */
      public Builder setOperationBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        operation_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Function)
    }

    // @@protoc_insertion_point(class_scope:Function)
    private static final cz.dusanrychnovsky.events.FunctionProto.Function DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new cz.dusanrychnovsky.events.FunctionProto.Function();
    }

    public static cz.dusanrychnovsky.events.FunctionProto.Function getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<Function>
        PARSER = new com.google.protobuf.AbstractParser<Function>() {
      public Function parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Function(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Function> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Function> getParserForType() {
      return PARSER;
    }

    public cz.dusanrychnovsky.events.FunctionProto.Function getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Function_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Function_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016function.proto\032\013event.proto\"7\n\010Functio" +
      "n\022\030\n\004type\030\001 \002(\0162\n.EventType\022\021\n\toperation" +
      "\030\002 \002(\tB*\n\031cz.dusanrychnovsky.eventsB\rFun" +
      "ctionProto"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cz.dusanrychnovsky.events.EventProto.getDescriptor(),
        }, assigner);
    internal_static_Function_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Function_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Function_descriptor,
        new java.lang.String[] { "Type", "Operation", });
    cz.dusanrychnovsky.events.EventProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
