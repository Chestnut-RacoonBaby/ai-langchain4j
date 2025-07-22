package com.ai.langchain4j.service;

import com.ai.langchain4j.entity.Appointment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author: qiaohaojie
 * @date: 2025-07-22 23:07:59
 */
public interface AppointmentService extends IService<Appointment> {

    Appointment getOne(Appointment appointment);
}
