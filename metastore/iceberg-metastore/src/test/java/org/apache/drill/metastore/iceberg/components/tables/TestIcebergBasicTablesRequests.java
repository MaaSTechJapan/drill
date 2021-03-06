/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.drill.metastore.iceberg.components.tables;

import org.apache.drill.metastore.components.tables.MetastoreTableInfo;
import org.apache.drill.metastore.components.tables.AbstractBasicTablesRequestsTest;
import org.apache.drill.metastore.iceberg.IcebergBaseTest;
import org.apache.drill.metastore.iceberg.IcebergMetastore;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestIcebergBasicTablesRequests extends AbstractBasicTablesRequestsTest {

  @BeforeClass
  public static void init() throws Exception {
    innerInit(IcebergBaseTest.baseIcebergConfig(defaultFolder.newFolder("iceberg-metastore")), IcebergMetastore.class);
  }

  @Test
  public void testMetastoreTableInfoExistingTable() {
    MetastoreTableInfo metastoreTableInfo = basicRequests.metastoreTableInfo(nationTableInfo);
    assertTrue(metastoreTableInfo.isExists());
    assertEquals(nationTableInfo, metastoreTableInfo.tableInfo());
    assertEquals(nationTable.lastModifiedTime(), metastoreTableInfo.lastModifiedTime());
    assertTrue(metastoreTableInfo.metastoreVersion() > 0);
  }
}
