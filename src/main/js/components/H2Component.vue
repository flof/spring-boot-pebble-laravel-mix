<template>
    <div id="h2-user">
        <div class="py-5 text-center">
            <div class="container">
                <div class="row">
                    <div class="mx-auto col-lg-8">
                        <h1>说明</h1>
                        <p class="mb-4">
                            这是一个Larvel Mix与Spring Data Rest Repository的样例。在下列表单中输入用户名和显示名称，数据将被添加到H2数据库中。
                        </p>
                        <form class="form-inline d-flex justify-content-around">
                            <div class="form-group">
                                <input class="form-control" id="name" placeholder="用户名称"
                                       type="text" v-model="formUser.name"></div>
                            <div class="form-group">
                                <input class="form-control" id="display-name" placeholder="显示名称"
                                       type="text" v-model="formUser.displayName"
                                ></div>
                            <button @click="saveUser()" class="btn btn-primary" type="button">添加用户</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">数据库</div>
                            <div class="card-body">
                                <h4>存储在H2数据库的人</h4>
                                <p>没有用户</p>
                                <div class="table-responsive">
                                    <table class="table table-bordered ">
                                        <thead class="thead-dark">
                                        <tr>
                                            <th>ID</th>
                                            <th>名称</th>
                                            <th>显示名称</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <th>1</th>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>删除</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        mounted() {
            console.log('Component Mounted');
            // this.read();
        },
        data: function () {
            return {
                msg: '',
                formUser: {
                    name: '',
                    displayName: ''
                },
                users: {}
            }
        },
        methods: {
            saveUser() {
                console.debug(this.formUser);
                window.axios.post('/api/v1/people', this.formUser).then((response) => {
                    console.debug(response.data);
                    const {content} = response.data;
                    console.debug(content);
                    this.msg = "更新成功！";
                });
            },
            getUsers() {
                window.axios.get('/api/v1/people').then((response) => {
                    const {content} = response.data;
                    this.users = content;
                });
            }
        }
    }
</script>
