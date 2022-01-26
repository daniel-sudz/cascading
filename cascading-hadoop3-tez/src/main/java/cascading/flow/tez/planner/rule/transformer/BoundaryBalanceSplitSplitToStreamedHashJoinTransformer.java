/*
 * Copyright (c) 2007-2022 The Cascading Authors. All Rights Reserved.
 *
 * Project and contact information: https://cascading.wensel.net/
 *
 * This file is part of the Cascading project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cascading.flow.tez.planner.rule.transformer;

import cascading.flow.planner.iso.expression.ElementCapture;
import cascading.flow.planner.rule.transformer.BoundaryElementFactory;
import cascading.flow.planner.rule.transformer.RuleInsertionTransformer;
import cascading.flow.tez.planner.rule.expression.BalanceSplitSplitToStreamedHashJoinExpression;

import static cascading.flow.planner.rule.PlanPhase.BalanceAssembly;

/**
 * Inserts Boundary after split that joins back into a HashJoin by way of another split.
 * <p>
 * this allows testGroupBySplitSplitGroupByJoin to pass
 */
public class BoundaryBalanceSplitSplitToStreamedHashJoinTransformer extends RuleInsertionTransformer
  {
  public BoundaryBalanceSplitSplitToStreamedHashJoinTransformer()
    {
    super(
      BalanceAssembly,
      new BalanceSplitSplitToStreamedHashJoinExpression(),
      ElementCapture.Secondary,
      BoundaryElementFactory.BOUNDARY_PIPE
    );
    }
  }
