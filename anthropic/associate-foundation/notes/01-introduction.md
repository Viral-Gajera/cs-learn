# Associate Foundation Course Notes

## 1. Foundations

Four decisions that sit at the front of every claude interaction

- core entry point | **chat** (quick task), **projects** (recurring task), **artifacts** (output is a deliverable), **research** (deep investigation)
- capability layer | project, skill, code execution, memory
- choosing model | haiku, sonnet, opus
- context management | long conversations degrade as context fills | restart, summarize, or persist

## 2. Prompting

- the competency of telling claude precisely what you want | description

1. anatomy of a prompt | role, context, task, constraints, output format
2. task decomposition | divide single prompt into multiple prompts (multi-step prompting)
3. refine prompts based on output | check which part of role/context/task/constraints/format is missing or unclear
4. adapting strategy by task type | analysis, research, drafting, brainstorming

## 3. Output Evaluation & Validating

- discernment | accuracy, completeness, fitness | check against 1. requirements, 2. source material, 3. professional standards | stakes calibration | a three-way triage
- hallucinations, inconsistencies & bias
- fact-checking & grounding | permission to not know, source restriction, auditable citation, quote-grounding
- diligence: when review is non-negotiable | risk thresholds 1. stakes 2. reversibility 3. audience 4. regulatory exposure
- editing & adapting for audience | clarity, tone, formatting
- choosing output formats | inline, artifact, structured

discernment is how you review; diligence is why you must.

## 4. Workflow Integration & Solution Design

decide which step to delegate to claude

- analyzing requirements & use cases | using claude
- research, planning & process optimization | using claude
- solution design, development & iteration | using claude
- delegation mapping | for each workflow step, decide who owns it: AI, a human, or both together.
- communicating value & limitations | of claude to stakeholders

## 5. Configuration & Knowledge Management

- configuring projects | standing instructions, knowledge base, scoped memory | skills
- connectors & uploaded knowledge
- system-level instructions that stick
- maintaining configurations | schedule regular maintenance for instructions, knowledge, skills, and memory

## 6. Governance, Risk & Responsible Use

governance tells how AI should be used

- appropriate vs inappropriate use cases
- skill trust & feature-level risk | source-and-permissions check before you enable skills | least privilege
- data sensitivity, privacy & feature controls | classify data before you upload | feature-specific controls: code execution sandbox, memory persistence, incognito mode, org-level memory controls
- organizational policies & diligence
- ethical implications | bias, fairness, transparency

## 7. Troubleshooting & Optimization

- diagnosing underperforming prompts & outputs | under-specification, context overload, wrong feature or model, stale configuration
- adjusting approach from feedback
- optimizing workflows | find redundancy, consolidate

## 8. Course Summary & Next Steps

- description, discernment, diligence, delegation
