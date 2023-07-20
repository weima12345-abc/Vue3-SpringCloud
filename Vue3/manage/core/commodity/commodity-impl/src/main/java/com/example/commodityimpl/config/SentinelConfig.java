package com.example.commodityimpl.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class SentinelConfig {
    private static final String KEY="ott";
    private static final String KEY_Using="ott2";
    @PostConstruct
    private void init(){
        initDegradeRule();
        initFlowQpsRule();
    }

    //熔断降级规则
    private void initDegradeRule(){
        List<DegradeRule> rules=new ArrayList<>();
        DegradeRule rule=new DegradeRule();
        rule.setResource(KEY);
        // 80s内调用接口出现 异常 ,次数超过5的时候, 进行熔断
        rule.setCount(5);
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        rule.setTimeWindow(80);
        rules.add(rule);
        DegradeRuleManager.loadRules(rules);
    }

    //流量控制规则
    private void initFlowQpsRule() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule(KEY);
        rule.setCount(1);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rules.add(rule);

        FlowRule rule2 = new FlowRule(KEY_Using);
        rule2.setCount(100);
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rules.add(rule2);
        FlowRuleManager.loadRules(rules);
    }

}
