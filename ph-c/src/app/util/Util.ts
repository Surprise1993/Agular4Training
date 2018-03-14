export class Util {
    getSecond() {
        const second = new Date().getSeconds();
        let Fdate = '';
        if (second < 10) {
            Fdate = '0' + second;
        } else {
            Fdate = second + '';
        }
        return Fdate;
    }
    getMinute() {
        const minute = new Date().getMinutes();
        let Fdate = '';
        if (minute < 10) {
            Fdate = '0' + minute;
        } else {
            Fdate = minute + '';
        }
        return Fdate;
    }
    getHour() {
        const hour = new Date().getHours();
        let Fdate = '';
        if (hour < 10) {
            Fdate = '0' + hour;
        } else {
            Fdate = hour + '';
        }
        return Fdate;
    }
    getDay() {
        const date = new Date().getDate();
        let Fdate = '';
        if (date < 10) {
            Fdate = '0' + date;
        } else {
            Fdate = date + '';
        }
        return Fdate;
    }
    getMonth() {
        const month = new Date().getMonth() + 1;
        let Fdate = '';
        if (month < 10) {
            Fdate = '0' + month;
        }
        return Fdate;
    }
    getYear() {
        const year = new Date().getFullYear();
        return year;
    }
    getToday() {
        return this.getYear() + '-' + this.getMonth() + '-' + this.getDay();
    }
    getMoment() {
        return this.getHour() + ':' + this.getMinute() + ':' + this.getSecond();
    }
}
