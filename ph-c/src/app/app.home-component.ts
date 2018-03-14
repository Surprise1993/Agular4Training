import { Component, OnInit, OnChanges } from '@angular/core';
import { ProPrsStatisticService } from './service/ProPrsStatistic-service';
import { Department } from './dto/Department';
import * as wjcCore from 'wijmo/wijmo';
import { Project } from './dto/Project';
import { Condition } from './dto/Condition';
import { Util } from './util/Util';
import { Person } from './dto/Person';

@Component({
    selector: 'app-home',
    templateUrl: './app.home-component.html',
    styleUrls: ['./css/app.component.css']
})
export class AppHomeComponent implements OnInit {
    deptList: Department[];
    proList: Project[];
    conList: Condition[];
    condition: Condition;
    perMapList = new wjcCore.CollectionView();
    constructor(
        private service: ProPrsStatisticService,
        private util: Util
    ) {
        this.deptList = new Array<Department>();
        this.proList = new Array<Project>();
        this.conList = new Array<Condition>();
        this.condition = new Condition;

    }
    ngOnInit() {
        this.service.selectAllDepartment().then(dept => this.deptList = dept);
        this.service.selectAllProject().then(pro => this.proList = pro);
        this.service.selectAllCondition().then(con => this.conList = con);
    }
    doConditionChange(conditionId: number) {
        for (let i = 0; i < this.conList.length; i++) {
            const a = this.conList[i];
            // tslint:disable-next-line:triple-equals
            if (a.selectId == conditionId) {
                this.condition = JSON.parse(JSON.stringify(a));
            }
        }
    }
    doAddCondition() {
        this.condition.useDate = this.util.getToday() + ' ' + this.util.getMoment();
        console.log(this.condition);
        this.service.insertCondition(this.condition).then(num => {
            if (num === 1) {
                alert('插入成功');
                this.service.selectAllCondition().then(con => this.conList = con);
            } else {
                alert('插入失败');
            }
        });
    }
    doDeductCondition() {
        this.service.deleteCondition(this.condition.selectId).then(num => {
            if (num === 1) {
                alert('删除成功');
                this.service.selectAllCondition().then(con => this.conList = con);
            } else {
                alert('删除失败');
            }
        });
    }
    doUpdateCondition() {
        this.condition.useDate = this.util.getToday() + ' ' + this.util.getMoment();
        this.service.updateCondition(this.condition).then(num => {
            if (num === 1) {
                alert('更新成功');
                this.service.selectAllCondition().then(con => this.conList = con);
            } else {
                alert('更新失败');
            }
        });
    }
    doSearchPerson() {
        console.log(this.condition);
        this.service.selectPerson(this.condition).then(per => {
        this.perMapList = new wjcCore.CollectionView(per);
            console.log(per);
            if (per.length === 0) {
                alert('查询结果为空！');
            }
        });
    }
}
