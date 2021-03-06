/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.graalvm.features.core;

import static com.google.cloud.graalvm.features.NativeImageUtils.registerClassHierarchyForReflection;

import com.oracle.svm.core.annotate.AutomaticFeature;
import org.graalvm.nativeimage.hosted.Feature;

/**
 * Provides Reflection declarations for GAPIC libraries.
 */
@AutomaticFeature
public class GapicFeature implements Feature {

  // Class member used to check library: com.google.api.grpc:proto-google-common-protos
  private static final String PROTO_GOOGLE_COMMONS_CLASS = "com.google.rpc.ResourceInfo";

  @Override
  public void beforeAnalysis(BeforeAnalysisAccess access) {
    Class<?> protosClass = access.findClassByName(PROTO_GOOGLE_COMMONS_CLASS);
    if (protosClass != null) {
      registerClassHierarchyForReflection(access, "com.google.rpc.BadRequest");
      registerClassHierarchyForReflection(access, "com.google.rpc.DebugInfo");
      registerClassHierarchyForReflection(access, "com.google.rpc.ErrorInfo");
      registerClassHierarchyForReflection(access, "com.google.rpc.Help");
      registerClassHierarchyForReflection(access, "com.google.rpc.LocalizedMessage");
      registerClassHierarchyForReflection(access, "com.google.rpc.QuotaFailure");
      registerClassHierarchyForReflection(access, "com.google.rpc.RequestInfo");
      registerClassHierarchyForReflection(access, "com.google.rpc.ResourceInfo");
      registerClassHierarchyForReflection(access, "com.google.rpc.RetryInfo");
      registerClassHierarchyForReflection(access, "com.google.rpc.Status");
    }
  }
}
