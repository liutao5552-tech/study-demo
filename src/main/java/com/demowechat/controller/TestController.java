package com.demowechat.controller;

import com.demowechat.service.TestService;
import com.demowechat.service.impl.TestServiceImpl;
import com.demowechat.service.impl.TestServiceImpl2;
import com.demowechat.data.Animal;
import com.demowechat.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private Animal animal;

    @Autowired
    private Animal animal1;

    @Autowired
    private Animal animal2;

    @Autowired
    private EmailUtil emailUtil;

    @GetMapping("/test1")
    public String test1(String type){
        TestService testService=new TestServiceImpl();
        TestService testService2=new TestServiceImpl2();

        return testService.getPayType(type)+testService2.getPayType(type);
    }

    @GetMapping("/test2")
    public void test2(){
        animal.sleep();
        animal.eat();

        animal1.eat();
        animal1.sleep();

        animal2.eat();
        animal2.sleep();
    }

    @GetMapping("/test3")
    public void test3(){
        emailUtil.sendTextEmail("liutao5552@qq.com", "测试标题", "测试内容");
        emailUtil.sendHtmlEmail("liutao5552@qq.com", "测试标题", "<div style=\" max-width: 500px; background: #020617; background-image: radial-gradient(circle at 50% 15%, #0284c7 0%, #070a13 50%, #020617 100%); padding: 35px 16px 40px 16px; font-family: -apple-system, BlinkMacSystemFont, 'PingFang SC', 'Microsoft YaHei', sans-serif; min-height: 100vh; display: block; box-sizing: border-box;    margin: 0 auto; box-shadow: 0 10px 35px rgba(0,0,0,0.6); overflow: hidden; position: relative;\">\n" +
                "    \n" +
                "    <!-- 顶部科技线条流模拟 -->\n" +
                "    <div style=\"position: absolute; left: 15%; top: 30px; width: 1px; height: 90px; background: linear-gradient(to bottom, transparent, rgba(56,189,248,0.3), transparent);\"></div>\n" +
                "    <div style=\"position: absolute; right: 15%; top: 70px; width: 1px; height: 70px; background: linear-gradient(to bottom, transparent, rgba(14,165,233,0.2), transparent);\"></div>\n" +
                "\n" +
                "    <!-- 主体框架 -->\n" +
                "    <div style=\"position: relative; z-index: 2; box-sizing: border-box;\">\n" +
                "\n" +
                "        <!-- ================= 头部：原图大标题与徽标区 ================= -->\n" +
                "        <div style=\"text-align: center; margin-bottom: 32px; padding: 0 10px;\">\n" +
                "            <!-- 三合一模拟徽标区（原图最上方三个标志） -->\n" +
                "            <div style=\"margin-bottom: 22px; opacity: 0.9; text-align: left; padding-left: 4px;\">\n" +
                "                <span style=\"display: inline-block; background: linear-gradient(135deg, #ef4444, #f59e0b); width: 14px; height: 14px; border-radius: 2px; margin-right: 4px; vertical-align: middle;\"></span>\n" +
                "                <span style=\"color: #38bdf8; font-size: 11px; font-weight: bold; font-family: monospace; letter-spacing: 0.5px; vertical-align: middle;\">ZHONG KE QI YUN</span>\n" +
                "                <span style=\"display: inline-block; border: 1px solid #ffffff; width: 12px; height: 12px; border-radius: 50%; margin-left: 8px; vertical-align: middle; opacity: 0.5;\"></span>\n" +
                "            </div>\n" +
                "\n" +
                "            <!-- 主标题：AI工具觉醒 -->\n" +
                "            <div style=\"color: #38bdf8; font-size: calc(23px + 0.4vw); font-weight: 900; letter-spacing: 2px; line-height: 1.25; text-shadow: 0 0 15px rgba(56,189,248,0.7); text-transform: uppercase; font-style: italic; text-align: left;\">\n" +
                "                AI工具觉醒\n" +
                "            </div>\n" +
                "            <!-- 副标题：从降本到增效 -->\n" +
                "            <div style=\"color: #38bdf8; font-size: calc(23px + 0.4vw); font-weight: 900; letter-spacing: 2px; line-height: 1.25; text-shadow: 0 0 15px rgba(56,189,248,0.7); text-transform: uppercase; font-style: italic; text-align: left; margin-top: 2px;\">\n" +
                "                从降本到增效\n" +
                "            </div>\n" +
                "            \n" +
                "            <!-- 培训会主题字样 -->\n" +
                "            <div style=\"color: #ffffff; font-size: calc(14px + 0.1vw); font-weight: bold; letter-spacing: 1.5px; margin-top: 12px; text-align: left; opacity: 0.95;\">\n" +
                "                2026企业AI实战培训会\n" +
                "            </div>\n" +
                "            <div style=\"color: #64748b; font-size: 9px; font-weight: bold; letter-spacing: 0.5px; margin-top: 2px; text-transform: uppercase; font-family: monospace; text-align: left; border-bottom: 1px solid rgba(255,255,255,0.1); padding-bottom: 12px;\">\n" +
                "                ENTERPRISE AI PRACTICAL TRAINING CONFERENCE\n" +
                "            </div>\n" +
                "\n" +
                "            <!-- 地点与日期 -->\n" +
                "            <div style=\"text-align: left; margin-top: 14px; color: #94a3b8; font-size: 11.5px;\">\n" +
                "                中国 · 杭州 | 国家地理标志农产品馆\n" +
                "            </div>\n" +
                "            <div style=\"text-align: left; margin-top: 4px; color: #38bdf8; font-size: calc(16px + 0.2vw); font-weight: 800; font-family: 'Arial Black', sans-serif; letter-spacing: 0.5px; text-shadow: 0 0 10px rgba(56,189,248,0.4);\">\n" +
                "                2026.3.9\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <!-- ================= 中部：会议流程章头 ================= -->\n" +
                "        <div style=\"text-align: center; margin-bottom: 22px; position: relative;\">\n" +
                "            <!-- 斜角高科技感底衬面 -->\n" +
                "            <div style=\"display: inline-block; background: linear-gradient(90deg, transparent 0%, #1e3a8a 25%, #1d4ed8 50%, #1e3a8a 75%, transparent 100%); padding: 6px 45px; border-left: 2px solid #00f2fe; border-right: 2px solid #00f2fe; transform: skewX(-10deg);\">\n" +
                "                <span style=\"color: #00f2fe; font-size: 16px; font-weight: 900; letter-spacing: 4px; transform: skewX(10deg); display: inline-block; text-shadow: 0 0 8px rgba(0,242,254,0.6);\">\n" +
                "                    会议流程\n" +
                "                </span>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <!-- ================= 核心：大蓝框日程面板 ================= -->\n" +
                "        <div style=\"background: rgba(10, 25, 47, 0.75); border: 1px solid rgba(56, 189, 248, 0.25); border-radius: 12px; padding: 22px 14px; box-shadow: 0 0 20px rgba(56,189,248,0.12); box-sizing: border-box;\">\n" +
                "            \n" +
                "            <!-- ---------------- 上午场 ---------------- -->\n" +
                "            <div style=\"display: table; width: 100%; margin-bottom: 16px; box-sizing: border-box;\">\n" +
                "                <div style=\"display: table-cell; width: 14px; vertical-align: middle;\">\n" +
                "                    <!-- 标志性双色数码小方块 -->\n" +
                "                    <div style=\"width: 5px; height: 5px; background-color: #38bdf8; display: block; margin-bottom: 2px;\"></div>\n" +
                "                    <div style=\"width: 5px; height: 5px; background-color: #2563eb; display: block; margin-left: 3px;\"></div>\n" +
                "                </div>\n" +
                "                <div style=\"display: table-cell; color: #38bdf8; font-size: 14px; font-weight: bold; vertical-align: middle; padding-left: 4px; letter-spacing: 0.5px;\">上午场</div>\n" +
                "                <div style=\"display: table-cell; color: #38bdf8; font-size: 12px; text-align: right; vertical-align: middle; opacity: 0.8; letter-spacing: 1px;\">会议内容</div>\n" +
                "            </div>\n" +
                "\n" +
                "            <!-- 上午列表容器 -->\n" +
                "            <div style=\"margin-bottom: 26px;\">\n" +
                "                <!-- 08:30-09:30 签到 -->\n" +
                "                <div style=\"display: table; width: 100%; table-layout: fixed; margin-bottom: 12px;\">\n" +
                "                    <div style=\"display: table-cell; width: 85px; color: #94a3b8; font-size: 12px; font-family: monospace; vertical-align: middle;\">08:30-09:30</div>\n" +
                "                    <div style=\"display: table-cell; width: 16px; text-align: center; vertical-align: middle;\">\n" +
                "                        <span style=\"width: 5px; height: 5px; background-color: #38bdf8; border: 1px solid #020617; border-radius: 50%; display: inline-block; box-shadow: 0 0 4px #38bdf8;\"></span>\n" +
                "                    </div>\n" +
                "                    <div style=\"display: table-cell; vertical-align: middle; padding-left: 6px; color: #ffffff; font-size: 12.5px; border-bottom: 1px solid rgba(255,255,255,0.05); padding-bottom: 8px;\">\n" +
                "                        签到\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <!-- 09:30-10:00 参观公司 -->\n" +
                "                <div style=\"display: table; width: 100%; table-layout: fixed; margin-bottom: 12px;\">\n" +
                "                    <div style=\"display: table-cell; width: 85px; color: #94a3b8; font-size: 12px; font-family: monospace; vertical-align: middle;\">09:30-10:00</div>\n" +
                "                    <div style=\"display: table-cell; width: 16px; text-align: center; vertical-align: middle;\">\n" +
                "                        <span style=\"width: 5px; height: 5px; background-color: #38bdf8; border: 1px solid #020617; border-radius: 50%; display: inline-block; box-shadow: 0 0 4px #38bdf8;\"></span>\n" +
                "                    </div>\n" +
                "                    <div style=\"display: table-cell; vertical-align: middle; padding-left: 6px; color: #ffffff; font-size: 12.5px; border-bottom: 1px solid rgba(255,255,255,0.05); padding-bottom: 8px;\">\n" +
                "                        参观公司\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <!-- 10:00-10:30 课程介绍 -->\n" +
                "                <div style=\"display: table; width: 100%; table-layout: fixed; margin-bottom: 12px;\">\n" +
                "                    <div style=\"display: table-cell; width: 85px; color: #94a3b8; font-size: 12px; font-family: monospace; vertical-align: middle;\">10:00-10:30</div>\n" +
                "                    <div style=\"display: table-cell; width: 16px; text-align: center; vertical-align: middle;\">\n" +
                "                        <span style=\"width: 5px; height: 5px; background-color: #38bdf8; border: 1px solid #020617; border-radius: 50%; display: inline-block; box-shadow: 0 0 4px #38bdf8;\"></span>\n" +
                "                    </div>\n" +
                "                    <div style=\"display: table-cell; vertical-align: middle; padding-left: 6px; color: #ffffff; font-size: 12.5px; border-bottom: 1px solid rgba(255,255,255,0.05); padding-bottom: 8px;\">\n" +
                "                        课程介绍\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <!-- 10:30-11:00 AI认知革命 -->\n" +
                "                <div style=\"display: table; width: 100%; table-layout: fixed; margin-bottom: 12px;\">\n" +
                "                    <div style=\"display: table-cell; width: 85px; color: #94a3b8; font-size: 12px; font-family: monospace; vertical-align: middle;\">10:30-11:00</div>\n" +
                "                    <div style=\"display: table-cell; width: 16px; text-align: center; vertical-align: middle;\">\n" +
                "                        <span style=\"width: 5px; height: 5px; background-color: #38bdf8; border: 1px solid #020617; border-radius: 50%; display: inline-block; box-shadow: 0 0 4px #38bdf8;\"></span>\n" +
                "                    </div>\n" +
                "                    <div style=\"display: table-cell; vertical-align: middle; padding-left: 6px; border-bottom: 1px solid rgba(255,255,255,0.05); padding-bottom: 8px;\">\n" +
                "                        <span style=\"color: #ffffff; font-size: 12.5px; font-weight: 500;\">AI认知革命</span>\n" +
                "                        <span style=\"color: #0ea5e9; font-size: 10px; margin-left: 8px; opacity: 0.8; white-space: nowrap;\">解锁前沿认知，把握技术风口</span>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <!-- 11:00-12:00 企业级GPT操作讲解 -->\n" +
                "                <div style=\"display: table; width: 100%; table-layout: fixed;\">\n" +
                "                    <div style=\"display: table-cell; width: 85px; color: #94a3b8; font-size: 12px; font-family: monospace; vertical-align: middle;\">11:00-12:00</div>\n" +
                "                    <div style=\"display: table-cell; width: 16px; text-align: center; vertical-align: middle;\">\n" +
                "                        <span style=\"width: 5px; height: 5px; background-color: #38bdf8; border: 1px solid #020617; border-radius: 50%; display: inline-block; box-shadow: 0 0 4px #38bdf8;\"></span>\n" +
                "                    </div>\n" +
                "                    <div style=\"display: table-cell; vertical-align: middle; padding-left: 6px; border-bottom: 1px solid rgba(255,255,255,0.05); padding-bottom: 8px;\">\n" +
                "                        <span style=\"color: #ffffff; font-size: 12.5px; font-weight: 500;\">企业级GPT操作讲解</span>\n" +
                "                        <span style=\"color: #0ea5e9; font-size: 10px; margin-left: 8px; opacity: 0.8; white-space: nowrap;\">从入门到精通</span>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <!-- ---------------- 下午场 ---------------- -->\n" +
                "            <div style=\"display: table; width: 100%; margin-bottom: 16px; box-sizing: border-box;\">\n" +
                "                <div style=\"display: table-cell; width: 14px; vertical-align: middle;\">\n" +
                "                    <div style=\"width: 5px; height: 5px; background-color: #38bdf8; display: block; margin-bottom: 2px;\"></div>\n" +
                "                    <div style=\"width: 5px; height: 5px; background-color: #2563eb; display: block; margin-left: 3px;\"></div>\n" +
                "                </div>\n" +
                "                <div style=\"display: table-cell; color: #38bdf8; font-size: 14px; font-weight: bold; vertical-align: middle; padding-left: 4px; letter-spacing: 0.5px;\">下午场</div>\n" +
                "                <div style=\"display: table-cell; color: #38bdf8; font-size: 12px; text-align: right; vertical-align: middle; opacity: 0.8; letter-spacing: 1px;\">会议内容</div>\n" +
                "            </div>\n" +
                "\n" +
                "            <!-- 下午列表容器 -->\n" +
                "            <div>\n" +
                "                <!-- 13:30-15:00 视频模型实战 -->\n" +
                "                <div style=\"display: table; width: 100%; table-layout: fixed; margin-bottom: 12px;\">\n" +
                "                    <div style=\"display: table-cell; width: 85px; color: #94a3b8; font-size: 12px; font-family: monospace; vertical-align: middle;\">13:30-15:00</div>\n" +
                "                    <div style=\"display: table-cell; width: 16px; text-align: center; vertical-align: middle;\">\n" +
                "                        <span style=\"width: 5px; height: 5px; background-color: #38bdf8; border: 1px solid #020617; border-radius: 50%; display: inline-block; box-shadow: 0 0 4px #38bdf8;\"></span>\n" +
                "                    </div>\n" +
                "                    <div style=\"display: table-cell; vertical-align: middle; padding-left: 6px; border-bottom: 1px solid rgba(255,255,255,0.05); padding-bottom: 8px;\">\n" +
                "                        <span style=\"color: #ffffff; font-size: 12.5px; font-weight: 500;\">视频模型实战</span>\n" +
                "                        <span style=\"color: #0ea5e9; font-size: 10px; margin-left: 8px; opacity: 0.8; white-space: nowrap;\">从理论到实操，落地视频类AI项目</span>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <!-- 15:00-15:30 GPT商业化实战 -->\n" +
                "                <div style=\"display: table; width: 100%; table-layout: fixed; margin-bottom: 12px;\">\n" +
                "                    <div style=\"display: table-cell; width: 85px; color: #94a3b8; font-size: 12px; font-family: monospace; vertical-align: middle;\">15:00-15:30</div>\n" +
                "                    <div style=\"display: table-cell; width: 16px; text-align: center; vertical-align: middle;\">\n" +
                "                        <span style=\"width: 5px; height: 5px; background-color: #38bdf8; border: 1px solid #020617; border-radius: 50%; display: inline-block; box-shadow: 0 0 4px #38bdf8;\"></span>\n" +
                "                    </div>\n" +
                "                    <div style=\"display: table-cell; vertical-align: middle; padding-left: 6px; border-bottom: 1px solid rgba(255,255,255,0.05); padding-bottom: 8px;\">\n" +
                "                        <span style=\"color: #ffffff; font-size: 12.5px; font-weight: 500;\">GPT商业化实战</span>\n" +
                "                        <span style=\"color: #0ea5e9; font-size: 10px; margin-left: 8px; opacity: 0.8; white-space: nowrap;\">手把手教学，掌握核心应用技巧</span>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <!-- 15:30-15:40 休息 -->\n" +
                "                <div style=\"display: table; width: 100%; table-layout: fixed; margin-bottom: 12px;\">\n" +
                "                    <div style=\"display: table-cell; width: 85px; color: #94a3b8; font-size: 12px; font-family: monospace; vertical-align: middle;\">15:30-15:40</div>\n" +
                "                    <div style=\"display: table-cell; width: 16px; text-align: center; vertical-align: middle;\">\n" +
                "                        <span style=\"width: 5px; height: 5px; background-color: #38bdf8; border: 1px solid #020617; border-radius: 50%; display: inline-block; box-shadow: 0 0 4px #38bdf8;\"></span>\n" +
                "                    </div>\n" +
                "                    <div style=\"display: table-cell; vertical-align: middle; padding-left: 6px; color: #ffffff; font-size: 12.5px; border-bottom: 1px solid rgba(255,255,255,0.05); padding-bottom: 8px;\">\n" +
                "                        休息\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <!-- 15:40-16:40 认识智能体和智能体搭建 -->\n" +
                "                <div style=\"display: table; width: 100%; table-layout: fixed; margin-bottom: 12px;\">\n" +
                "                    <div style=\"display: table-cell; width: 85px; color: #94a3b8; font-size: 12px; font-family: monospace; vertical-align: middle;\">15:40-16:40</div>\n" +
                "                    <div style=\"display: table-cell; width: 16px; text-align: center; vertical-align: middle;\">\n" +
                "                        <span style=\"width: 5px; height: 5px; background-color: #38bdf8; border: 1px solid #020617; border-radius: 50%; display: inline-block; box-shadow: 0 0 4px #38bdf8;\"></span>\n" +
                "                    </div>\n" +
                "                    <div style=\"display: table-cell; vertical-align: middle; padding-left: 6px; border-bottom: 1px solid rgba(255,255,255,0.05); padding-bottom: 8px;\">\n" +
                "                        <div style=\"color: #ffffff; font-size: 12.5px; font-weight: 500;\">认识智能体和智能体搭建</div>\n" +
                "                        <div style=\"color: #0ea5e9; font-size: 10px; margin-top: 2px; opacity: 0.8;\">零基础入门 快速构建专属智能体</div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <!-- 16:40-17:20 企业落地路径+行动计划 -->\n" +
                "                <div style=\"display: table; width: 100%; table-layout: fixed; margin-bottom: 12px;\">\n" +
                "                    <div style=\"display: table-cell; width: 85px; color: #94a3b8; font-size: 12px; font-family: monospace; vertical-align: middle;\">16:40-17:20</div>\n" +
                "                    <div style=\"display: table-cell; width: 16px; text-align: center; vertical-align: middle;\">\n" +
                "                        <span style=\"width: 5px; height: 5px; background-color: #38bdf8; border: 1px solid #020617; border-radius: 50%; display: inline-block; box-shadow: 0 0 4px #38bdf8;\"></span>\n" +
                "                    </div>\n" +
                "                    <div style=\"display: table-cell; vertical-align: middle; padding-left: 6px; border-bottom: 1px solid rgba(255,255,255,0.05); padding-bottom: 8px;\">\n" +
                "                        <span style=\"color: #ffffff; font-size: 12.5px; font-weight: 500;\">企业落地路径+行动计划</span>\n" +
                "                        <span style=\"color: #0ea5e9; font-size: 10px; margin-left: 8px; opacity: 0.8; white-space: nowrap;\">定制化方案 推动AI高效落地</span>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <!-- 17:20-18:00 企业应用复盘 -->\n" +
                "                <div style=\"display: table; width: 100%; table-layout: fixed;\">\n" +
                "                    <div style=\"display: table-cell; width: 85px; color: #94a3b8; font-size: 12px; font-family: monospace; vertical-align: middle;\">17:20-18:00</div>\n" +
                "                    <div style=\"display: table-cell; width: 16px; text-align: center; vertical-align: middle;\">\n" +
                "                        <span style=\"width: 5px; height: 5px; background-color: #38bdf8; border: 1px solid #020617; border-radius: 50%; display: inline-block; box-shadow: 0 0 4px #38bdf8;\"></span>\n" +
                "                    </div>\n" +
                "                    <div style=\"display: table-cell; vertical-align: middle; padding-left: 6px; padding-bottom: 2px;\">\n" +
                "                        <span style=\"color: #ffffff; font-size: 12.5px; font-weight: 500;\">企业应用复盘</span>\n" +
                "                        <span style=\"color: #0ea5e9; font-size: 10px; margin-left: 8px; opacity: 0.8; white-space: nowrap;\">应用实践复盘与路径升级</span>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>");
    }
}
