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
import org.apache.kafka.common.protocol.ObjectSerializationCache;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.RawTaggedField;
import org.apache.kafka.common.protocol.types.RawTaggedFieldWriter;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Struct;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.ByteUtils;


public class DescribeAclsRequestData implements ApiMessage {
    private byte resourceType;
    private String resourceNameFilter;
    private byte resourcePatternType;
    private String principalFilter;
    private String hostFilter;
    private byte operation;
    private byte permissionType;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("resource_type", Type.INT8, "The resource type."),
            new Field("resource_name_filter", Type.NULLABLE_STRING, "The resource name, or null to match any resource name."),
            new Field("principal_filter", Type.NULLABLE_STRING, "The principal to match, or null to match any principal."),
            new Field("host_filter", Type.NULLABLE_STRING, "The host to match, or null to match any host."),
            new Field("operation", Type.INT8, "The operation to match."),
            new Field("permission_type", Type.INT8, "The permission type to match.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("resource_type", Type.INT8, "The resource type."),
            new Field("resource_name_filter", Type.NULLABLE_STRING, "The resource name, or null to match any resource name."),
            new Field("resource_pattern_type", Type.INT8, "The resource pattern to match."),
            new Field("principal_filter", Type.NULLABLE_STRING, "The principal to match, or null to match any principal."),
            new Field("host_filter", Type.NULLABLE_STRING, "The host to match, or null to match any host."),
            new Field("operation", Type.INT8, "The operation to match."),
            new Field("permission_type", Type.INT8, "The permission type to match.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public DescribeAclsRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public DescribeAclsRequestData(Struct struct, short _version) {
        fromStruct(struct, _version);
    }
    
    public DescribeAclsRequestData() {
        this.resourceType = (byte) 0;
        this.resourceNameFilter = "";
        this.resourcePatternType = (byte) 3;
        this.principalFilter = "";
        this.hostFilter = "";
        this.operation = (byte) 0;
        this.permissionType = (byte) 0;
    }
    
    @Override
    public short apiKey() {
        return 29;
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
        this.resourceType = _readable.readByte();
        {
            int length;
            length = _readable.readShort();
            if (length < 0) {
                this.resourceNameFilter = null;
            } else if (length > 0x7fff) {
                throw new RuntimeException("string field resourceNameFilter had invalid length " + length);
            } else {
                this.resourceNameFilter = _readable.readString(length);
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
                this.principalFilter = null;
            } else if (length > 0x7fff) {
                throw new RuntimeException("string field principalFilter had invalid length " + length);
            } else {
                this.principalFilter = _readable.readString(length);
            }
        }
        {
            int length;
            length = _readable.readShort();
            if (length < 0) {
                this.hostFilter = null;
            } else if (length > 0x7fff) {
                throw new RuntimeException("string field hostFilter had invalid length " + length);
            } else {
                this.hostFilter = _readable.readString(length);
            }
        }
        this.operation = _readable.readByte();
        this.permissionType = _readable.readByte();
        this._unknownTaggedFields = null;
    }
    
    @Override
    public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        _writable.writeByte(resourceType);
        if (resourceNameFilter == null) {
            _writable.writeShort((short) -1);
        } else {
            byte[] _stringBytes = _cache.getSerializedValue(resourceNameFilter);
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
        if (principalFilter == null) {
            _writable.writeShort((short) -1);
        } else {
            byte[] _stringBytes = _cache.getSerializedValue(principalFilter);
            _writable.writeShort((short) _stringBytes.length);
            _writable.writeByteArray(_stringBytes);
        }
        if (hostFilter == null) {
            _writable.writeShort((short) -1);
        } else {
            byte[] _stringBytes = _cache.getSerializedValue(hostFilter);
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
        this._unknownTaggedFields = null;
        this.resourceType = struct.getByte("resource_type");
        this.resourceNameFilter = struct.getString("resource_name_filter");
        if (_version >= 1) {
            this.resourcePatternType = struct.getByte("resource_pattern_type");
        } else {
            this.resourcePatternType = (byte) 3;
        }
        this.principalFilter = struct.getString("principal_filter");
        this.hostFilter = struct.getString("host_filter");
        this.operation = struct.getByte("operation");
        this.permissionType = struct.getByte("permission_type");
    }
    
    @Override
    public Struct toStruct(short _version) {
        TreeMap<Integer, Object> _taggedFields = null;
        Struct struct = new Struct(SCHEMAS[_version]);
        struct.set("resource_type", this.resourceType);
        struct.set("resource_name_filter", this.resourceNameFilter);
        if (_version >= 1) {
            struct.set("resource_pattern_type", this.resourcePatternType);
        } else {
            if (resourcePatternType != (byte) 3) {
                throw new UnsupportedVersionException("Attempted to write a non-default resourcePatternType at version " + _version);
            }
        }
        struct.set("principal_filter", this.principalFilter);
        struct.set("host_filter", this.hostFilter);
        struct.set("operation", this.operation);
        struct.set("permission_type", this.permissionType);
        return struct;
    }
    
    @Override
    public int size(ObjectSerializationCache _cache, short _version) {
        int _size = 0, _numTaggedFields = 0;
        _size += 1;
        if (resourceNameFilter == null) {
            _size += 2;
        } else {
            byte[] _stringBytes = resourceNameFilter.getBytes(StandardCharsets.UTF_8);
            if (_stringBytes.length > 0x7fff) {
                throw new RuntimeException("'resourceNameFilter' field is too long to be serialized");
            }
            _cache.cacheSerializedValue(resourceNameFilter, _stringBytes);
            _size += _stringBytes.length + 2;
        }
        if (_version >= 1) {
            _size += 1;
        }
        if (principalFilter == null) {
            _size += 2;
        } else {
            byte[] _stringBytes = principalFilter.getBytes(StandardCharsets.UTF_8);
            if (_stringBytes.length > 0x7fff) {
                throw new RuntimeException("'principalFilter' field is too long to be serialized");
            }
            _cache.cacheSerializedValue(principalFilter, _stringBytes);
            _size += _stringBytes.length + 2;
        }
        if (hostFilter == null) {
            _size += 2;
        } else {
            byte[] _stringBytes = hostFilter.getBytes(StandardCharsets.UTF_8);
            if (_stringBytes.length > 0x7fff) {
                throw new RuntimeException("'hostFilter' field is too long to be serialized");
            }
            _cache.cacheSerializedValue(hostFilter, _stringBytes);
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
        if (!(obj instanceof DescribeAclsRequestData)) return false;
        DescribeAclsRequestData other = (DescribeAclsRequestData) obj;
        if (resourceType != other.resourceType) return false;
        if (this.resourceNameFilter == null) {
            if (other.resourceNameFilter != null) return false;
        } else {
            if (!this.resourceNameFilter.equals(other.resourceNameFilter)) return false;
        }
        if (resourcePatternType != other.resourcePatternType) return false;
        if (this.principalFilter == null) {
            if (other.principalFilter != null) return false;
        } else {
            if (!this.principalFilter.equals(other.principalFilter)) return false;
        }
        if (this.hostFilter == null) {
            if (other.hostFilter != null) return false;
        } else {
            if (!this.hostFilter.equals(other.hostFilter)) return false;
        }
        if (operation != other.operation) return false;
        if (permissionType != other.permissionType) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + resourceType;
        hashCode = 31 * hashCode + (resourceNameFilter == null ? 0 : resourceNameFilter.hashCode());
        hashCode = 31 * hashCode + resourcePatternType;
        hashCode = 31 * hashCode + (principalFilter == null ? 0 : principalFilter.hashCode());
        hashCode = 31 * hashCode + (hostFilter == null ? 0 : hostFilter.hashCode());
        hashCode = 31 * hashCode + operation;
        hashCode = 31 * hashCode + permissionType;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DescribeAclsRequestData("
            + "resourceType=" + resourceType
            + ", resourceNameFilter=" + ((resourceNameFilter == null) ? "null" : "'" + resourceNameFilter.toString() + "'")
            + ", resourcePatternType=" + resourcePatternType
            + ", principalFilter=" + ((principalFilter == null) ? "null" : "'" + principalFilter.toString() + "'")
            + ", hostFilter=" + ((hostFilter == null) ? "null" : "'" + hostFilter.toString() + "'")
            + ", operation=" + operation
            + ", permissionType=" + permissionType
            + ")";
    }
    
    public byte resourceType() {
        return this.resourceType;
    }
    
    public String resourceNameFilter() {
        return this.resourceNameFilter;
    }
    
    public byte resourcePatternType() {
        return this.resourcePatternType;
    }
    
    public String principalFilter() {
        return this.principalFilter;
    }
    
    public String hostFilter() {
        return this.hostFilter;
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
    
    public DescribeAclsRequestData setResourceType(byte v) {
        this.resourceType = v;
        return this;
    }
    
    public DescribeAclsRequestData setResourceNameFilter(String v) {
        this.resourceNameFilter = v;
        return this;
    }
    
    public DescribeAclsRequestData setResourcePatternType(byte v) {
        this.resourcePatternType = v;
        return this;
    }
    
    public DescribeAclsRequestData setPrincipalFilter(String v) {
        this.principalFilter = v;
        return this;
    }
    
    public DescribeAclsRequestData setHostFilter(String v) {
        this.hostFilter = v;
        return this;
    }
    
    public DescribeAclsRequestData setOperation(byte v) {
        this.operation = v;
        return this;
    }
    
    public DescribeAclsRequestData setPermissionType(byte v) {
        this.permissionType = v;
        return this;
    }
}
