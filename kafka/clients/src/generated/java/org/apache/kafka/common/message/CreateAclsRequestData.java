/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// THIS CODE IS AUTOMATICALLY GENERATED.  DO NOT EDIT.

package org.apache.kafka.common.message;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.Message;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.ObjectSerializationCache;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.ArrayOf;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.RawTaggedField;
import org.apache.kafka.common.protocol.types.RawTaggedFieldWriter;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Struct;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.ByteUtils;


public class CreateAclsRequestData implements ApiMessage {
    private List<CreatableAcl> creations;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("creations", new ArrayOf(CreatableAcl.SCHEMA_0), "The ACLs that we want to create.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("creations", new ArrayOf(CreatableAcl.SCHEMA_1), "The ACLs that we want to create.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public CreateAclsRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public CreateAclsRequestData(Struct struct, short _version) {
        fromStruct(struct, _version);
    }
    
    public CreateAclsRequestData() {
        this.creations = new ArrayList<CreatableAcl>();
    }
    
    @Override
    public short apiKey() {
        return 30;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 1;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        {
            int arrayLength;
            arrayLength = _readable.readInt();
            if (arrayLength < 0) {
                throw new RuntimeException("non-nullable field creations was serialized as null");
            } else {
                ArrayList<CreatableAcl> newCollection = new ArrayList<CreatableAcl>(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    newCollection.add(new CreatableAcl(_readable, _version));
                }
                this.creations = newCollection;
            }
        }
        this._unknownTaggedFields = null;
    }
    
    @Override
    public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        _writable.writeInt(creations.size());
        for (CreatableAcl creationsElement : creations) {
            creationsElement.write(_writable, _cache, _version);
        }
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        if (_numTaggedFields > 0) {
            throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void fromStruct(Struct struct, short _version) {
        this._unknownTaggedFields = null;
        {
            Object[] _nestedObjects = struct.getArray("creations");
            this.creations = new ArrayList<CreatableAcl>(_nestedObjects.length);
            for (Object nestedObject : _nestedObjects) {
                this.creations.add(new CreatableAcl((Struct) nestedObject, _version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short _version) {
        TreeMap<Integer, Object> _taggedFields = null;
        Struct struct = new Struct(SCHEMAS[_version]);
        {
            Struct[] _nestedObjects = new Struct[creations.size()];
            int i = 0;
            for (CreatableAcl element : this.creations) {
                _nestedObjects[i++] = element.toStruct(_version);
            }
            struct.set("creations", (Object[]) _nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(ObjectSerializationCache _cache, short _version) {
        int _size = 0, _numTaggedFields = 0;
        {
            int _arraySize = 0;
            _arraySize += 4;
            for (CreatableAcl creationsElement : creations) {
                _arraySize += creationsElement.size(_cache, _version);
            }
            _size += _arraySize;
        }
        if (_unknownTaggedFields != null) {
            _numTaggedFields += _unknownTaggedFields.size();
            for (RawTaggedField _field : _unknownTaggedFields) {
                _size += ByteUtils.sizeOfUnsignedVarint(_field.tag());
                _size += ByteUtils.sizeOfUnsignedVarint(_field.size());
                _size += _field.size();
            }
        }
        if (_numTaggedFields > 0) {
            throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
        }
        return _size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CreateAclsRequestData)) return false;
        CreateAclsRequestData other = (CreateAclsRequestData) obj;
        if (this.creations == null) {
            if (other.creations != null) return false;
        } else {
            if (!this.creations.equals(other.creations)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (creations == null ? 0 : creations.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "CreateAclsRequestData("
            + "creations=" + MessageUtil.deepToString(creations.iterator())
            + ")";
    }
    
    public List<CreatableAcl> creations() {
        return this.creations;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public CreateAclsRequestData setCreations(List<CreatableAcl> v) {
        this.creations = v;
        return this;
    }
    
    static public class CreatableAcl implements Message {
        private byte resourceType;
        private String resourceName;
        private byte resourcePatternType;
        private String principal;
        private String host;
        private byte operation;
        private byte permissionType;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("resource_type", Type.INT8, "The type of the resource."),
                new Field("resource_name", Type.STRING, "The resource name for the ACL."),
                new Field("principal", Type.STRING, "The principal for the ACL."),
                new Field("host", Type.STRING, "The host for the ACL."),
                new Field("operation", Type.INT8, "The operation type for the ACL (read, write, etc.)."),
                new Field("permission_type", Type.INT8, "The permission type for the ACL (allow, deny, etc.).")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("resource_type", Type.INT8, "The type of the resource."),
                new Field("resource_name", Type.STRING, "The resource name for the ACL."),
                new Field("resource_pattern_type", Type.INT8, "The pattern type for the ACL."),
                new Field("principal", Type.STRING, "The principal for the ACL."),
                new Field("host", Type.STRING, "The host for the ACL."),
                new Field("operation", Type.INT8, "The operation type for the ACL (read, write, etc.)."),
                new Field("permission_type", Type.INT8, "The permission type for the ACL (allow, deny, etc.).")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public CreatableAcl(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public CreatableAcl(Struct struct, short _version) {
            fromStruct(struct, _version);
        }
        
        public CreatableAcl() {
            this.resourceType = (byte) 0;
            this.resourceName = "";
            this.resourcePatternType = (byte) 3;
            this.principal = "";
            this.host = "";
            this.operation = (byte) 0;
            this.permissionType = (byte) 0;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 1;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 1) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of CreatableAcl");
            }
            this.resourceType = _readable.readByte();
            {
                int length;
                length = _readable.readShort();
                if (length < 0) {
                    throw new RuntimeException("non-nullable field resourceName was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field resourceName had invalid length " + length);
                } else {
                    this.resourceName = _readable.readString(length);
                }
            }
            if (_version >= 1) {
                this.resourcePatternType = _readable.readByte();
            } else {
                this.resourcePatternType = (byte) 3;
            }
            {
                int length;
                length = _readable.readShort();
                if (length < 0) {
                    throw new RuntimeException("non-nullable field principal was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field principal had invalid length " + length);
                } else {
                    this.principal = _readable.readString(length);
                }
            }
            {
                int length;
                length = _readable.readShort();
                if (length < 0) {
                    throw new RuntimeException("non-nullable field host was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field host had invalid length " + length);
                } else {
                    this.host = _readable.readString(length);
                }
            }
            this.operation = _readable.readByte();
            this.permissionType = _readable.readByte();
            this._unknownTaggedFields = null;
        }
        
        @Override
        public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
            if (_version > 1) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of CreatableAcl");
            }
            int _numTaggedFields = 0;
            _writable.writeByte(resourceType);
            {
                byte[] _stringBytes = _cache.getSerializedValue(resourceName);
                _writable.writeShort((short) _stringBytes.length);
                _writable.writeByteArray(_stringBytes);
            }
            if (_version >= 1) {
                _writable.writeByte(resourcePatternType);
            } else {
                if (resourcePatternType != (byte) 3) {
                    throw new UnsupportedVersionException("Attempted to write a non-default resourcePatternType at version " + _version);
                }
            }
            {
                byte[] _stringBytes = _cache.getSerializedValue(principal);
                _writable.writeShort((short) _stringBytes.length);
                _writable.writeByteArray(_stringBytes);
            }
            {
                byte[] _stringBytes = _cache.getSerializedValue(host);
                _writable.writeShort((short) _stringBytes.length);
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeByte(operation);
            _writable.writeByte(permissionType);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public void fromStruct(Struct struct, short _version) {
            if (_version > 1) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of CreatableAcl");
            }
            this._unknownTaggedFields = null;
            this.resourceType = struct.getByte("resource_type");
            this.resourceName = struct.getString("resource_name");
            if (_version >= 1) {
                this.resourcePatternType = struct.getByte("resource_pattern_type");
            } else {
                this.resourcePatternType = (byte) 3;
            }
            this.principal = struct.getString("principal");
            this.host = struct.getString("host");
            this.operation = struct.getByte("operation");
            this.permissionType = struct.getByte("permission_type");
        }
        
        @Override
        public Struct toStruct(short _version) {
            if (_version > 1) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of CreatableAcl");
            }
            TreeMap<Integer, Object> _taggedFields = null;
            Struct struct = new Struct(SCHEMAS[_version]);
            struct.set("resource_type", this.resourceType);
            struct.set("resource_name", this.resourceName);
            if (_version >= 1) {
                struct.set("resource_pattern_type", this.resourcePatternType);
            } else {
                if (resourcePatternType != (byte) 3) {
                    throw new UnsupportedVersionException("Attempted to write a non-default resourcePatternType at version " + _version);
                }
            }
            struct.set("principal", this.principal);
            struct.set("host", this.host);
            struct.set("operation", this.operation);
            struct.set("permission_type", this.permissionType);
            return struct;
        }
        
        @Override
        public int size(ObjectSerializationCache _cache, short _version) {
            int _size = 0, _numTaggedFields = 0;
            if (_version > 1) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of CreatableAcl");
            }
            _size += 1;
            {
                byte[] _stringBytes = resourceName.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'resourceName' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(resourceName, _stringBytes);
                _size += _stringBytes.length + 2;
            }
            if (_version >= 1) {
                _size += 1;
            }
            {
                byte[] _stringBytes = principal.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'principal' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(principal, _stringBytes);
                _size += _stringBytes.length + 2;
            }
            {
                byte[] _stringBytes = host.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'host' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(host, _stringBytes);
                _size += _stringBytes.length + 2;
            }
            _size += 1;
            _size += 1;
            if (_unknownTaggedFields != null) {
                _numTaggedFields += _unknownTaggedFields.size();
                for (RawTaggedField _field : _unknownTaggedFields) {
                    _size += ByteUtils.sizeOfUnsignedVarint(_field.tag());
                    _size += ByteUtils.sizeOfUnsignedVarint(_field.size());
                    _size += _field.size();
                }
            }
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
            return _size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CreatableAcl)) return false;
            CreatableAcl other = (CreatableAcl) obj;
            if (resourceType != other.resourceType) return false;
            if (this.resourceName == null) {
                if (other.resourceName != null) return false;
            } else {
                if (!this.resourceName.equals(other.resourceName)) return false;
            }
            if (resourcePatternType != other.resourcePatternType) return false;
            if (this.principal == null) {
                if (other.principal != null) return false;
            } else {
                if (!this.principal.equals(other.principal)) return false;
            }
            if (this.host == null) {
                if (other.host != null) return false;
            } else {
                if (!this.host.equals(other.host)) return false;
            }
            if (operation != other.operation) return false;
            if (permissionType != other.permissionType) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + resourceType;
            hashCode = 31 * hashCode + (resourceName == null ? 0 : resourceName.hashCode());
            hashCode = 31 * hashCode + resourcePatternType;
            hashCode = 31 * hashCode + (principal == null ? 0 : principal.hashCode());
            hashCode = 31 * hashCode + (host == null ? 0 : host.hashCode());
            hashCode = 31 * hashCode + operation;
            hashCode = 31 * hashCode + permissionType;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "CreatableAcl("
                + "resourceType=" + resourceType
                + ", resourceName=" + ((resourceName == null) ? "null" : "'" + resourceName.toString() + "'")
                + ", resourcePatternType=" + resourcePatternType
                + ", principal=" + ((principal == null) ? "null" : "'" + principal.toString() + "'")
                + ", host=" + ((host == null) ? "null" : "'" + host.toString() + "'")
                + ", operation=" + operation
                + ", permissionType=" + permissionType
                + ")";
        }
        
        public byte resourceType() {
            return this.resourceType;
        }
        
        public String resourceName() {
            return this.resourceName;
        }
        
        public byte resourcePatternType() {
            return this.resourcePatternType;
        }
        
        public String principal() {
            return this.principal;
        }
        
        public String host() {
            return this.host;
        }
        
        public byte operation() {
            return this.operation;
        }
        
        public byte permissionType() {
            return this.permissionType;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public CreatableAcl setResourceType(byte v) {
            this.resourceType = v;
            return this;
        }
        
        public CreatableAcl setResourceName(String v) {
            this.resourceName = v;
            return this;
        }
        
        public CreatableAcl setResourcePatternType(byte v) {
            this.resourcePatternType = v;
            return this;
        }
        
        public CreatableAcl setPrincipal(String v) {
            this.principal = v;
            return this;
        }
        
        public CreatableAcl setHost(String v) {
            this.host = v;
            return this;
        }
        
        public CreatableAcl setOperation(byte v) {
            this.operation = v;
            return this;
        }
        
        public CreatableAcl setPermissionType(byte v) {
            this.permissionType = v;
            return this;
        }
    }
}
