package chotchachi.com.jobs

import org.quartz.Scheduler
import org.quartz.SchedulerFactory
import org.quartz.impl.StdSchedulerFactory
import java.util.*

class JobSchedulerManager {

    var scheduler: Scheduler

    init {
        val props = Properties()
        props["org.quartz.scheduler.instanceName"] = "ChuckNorrisScheduler"
        props["org.quartz.threadPool.threadCount"] = "3"

        props["org.quartz.plugin.triggHistory.class"] = "org.quartz.plugins.history.LoggingTriggerHistoryPlugin"
        props["org.quartz.plugin.triggHistory.triggerFiredMessage"] = """Trigger {1}.{0} fired job {6}.{5} at: {4, date, HH:mm:ss MM/dd/yyyy}"""
        props["org.quartz.plugin.triggHistory.triggerCompleteMessage"] = """Trigger {1}.{0} completed firing job {6}.{5} at {4, date, HH:mm:ss MM/dd/yyyy}"""

        val schedulerFactory: SchedulerFactory = StdSchedulerFactory(props)
        scheduler = schedulerFactory.scheduler
    }

    fun startScheduler() {
        scheduler.start()
    }
}