import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Condition } from '../dto/Condition';
import { Project } from '../dto/Project';
import { Department } from '../dto/Department';
import { Person } from '../dto/Person';

@Injectable()
export class ProPrsStatisticService {
    private RestRootUrl = 'training/api';  // URL to web api
    constructor(
        private http: Http
    ) { }

    selectAllCondition(): Promise<Condition[]> {
        return this.http.get(`${this.RestRootUrl}/conditions`)
            .toPromise()
            .then(response => response.json() as Condition[])
            .catch(this.handleError);
    }
    selectPerson(condition: Condition): Promise<Person[]> {
        return this.http.post(`${this.RestRootUrl}/personsFor366`, condition)
            .toPromise()
            .then(response => response.json())
            .catch(this.handleError);
    }

    selectAllProject(): Promise<Project[]> {
        return this.http.get(`${this.RestRootUrl}/projects`)
            .toPromise()
            .then(response => response.json() as Project[])
            .catch(this.handleError);
    }
    selectAllDepartment(): Promise<Department[]> {
        return this.http.get(`${this.RestRootUrl}/departments`)
            .toPromise()
            .then(response => response.json() as Department[])
            .catch(this.handleError);
    }
    insertCondition(condition: Condition): Promise<Number> {
        return this.http.post(`${this.RestRootUrl}/insertCondition`, condition)
            .toPromise()
            .then(response => response.json() as Number)
            .catch(this.handleError);
    }
    updateCondition(condition: Condition): Promise<Number> {
        return this.http.post(`${this.RestRootUrl}/updateCondition`, condition)
            .toPromise()
            .then(response => response.json() as Number)
            .catch(this.handleError);
    }
    deleteCondition(conditionId: number): Promise<Number> {
        return this.http.delete(`${this.RestRootUrl}/deleteCondition/${conditionId}`)
            .toPromise()
            .then(response => response.json() as Number)
            .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('', error);
        return Promise.reject(error.message || error);
    }
}
